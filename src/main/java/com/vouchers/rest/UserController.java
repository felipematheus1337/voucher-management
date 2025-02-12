package com.vouchers.rest;

import com.vouchers.dtos.CreateUserDTO;
import com.vouchers.models.User;
import com.vouchers.services.AuthorizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final AuthorizationService authorizationService;

    public UserController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping("/users")
    public ResponseEntity<Void> newUser(@RequestBody CreateUserDTO dto) {

        this.authorizationService.createUser(dto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(authorizationService.listUsers());
    }
}
