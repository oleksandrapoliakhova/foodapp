package com.foodapp.foodapp.controllers.auth;

import com.foodapp.foodapp.services.auth.LogoutService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LogoutController {
  private final LogoutService logoutService;

  @PostMapping("/logout")
  public void logout(@RequestBody HttpServletRequest request,
                     @RequestBody HttpServletResponse response,
                     @RequestBody Authentication authentication) {
    logoutService.logout(request, response, authentication);
  }
}
