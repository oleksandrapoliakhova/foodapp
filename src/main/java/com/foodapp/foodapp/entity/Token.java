package com.foodapp.foodapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.foodapp.foodapp.types.TokenType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TOKEN")
public class Token {

  @Id
  @GeneratedValue
  public Integer id;

  public String token;

  @Enumerated(EnumType.STRING)
  public TokenType tokenType = TokenType.BEARER;

  public boolean revoked;

  public boolean expired;

  @ManyToOne
  @JoinColumn(name = "user_id")
  public User user;
}
