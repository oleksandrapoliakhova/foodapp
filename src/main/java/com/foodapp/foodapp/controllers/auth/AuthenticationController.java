package com.foodapp.foodapp.controllers.auth;

import com.foodapp.foodapp.FoodappRuntimeException;
import com.foodapp.foodapp.auth.AuthenticationRequest;
import com.foodapp.foodapp.auth.AuthenticationResponse;
import com.foodapp.foodapp.auth.RegisterRequest;
import com.foodapp.foodapp.services.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request)
            throws FoodappRuntimeException {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
