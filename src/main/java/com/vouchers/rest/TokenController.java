package com.vouchers.rest;


import com.vouchers.dtos.LoginRequest;
import com.vouchers.dtos.LoginResponse;
import com.vouchers.services.AuthorizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    private final AuthorizationService authorizationService;

    public TokenController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        return ResponseEntity.ok(authorizationService.login(loginRequest));
    }
}
