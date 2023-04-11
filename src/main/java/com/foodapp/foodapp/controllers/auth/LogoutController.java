package com.foodapp.foodapp.controllers.auth;

import com.foodapp.foodapp.services.auth.LogoutService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class LogoutController {
  private final LogoutService logoutService;

  @PostMapping("/logout")
  public void logout(@RequestBody HttpServletRequest request,
                     @RequestBody HttpServletResponse response,
                     @RequestBody Authentication authentication) {
    logoutService.logout(request, response, authentication);
  }
}
