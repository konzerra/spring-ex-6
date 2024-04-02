package org.konzerra.springex6.domain.auth;

import lombok.RequiredArgsConstructor;
import org.konzerra.springex6.domain.auth.dto.AuthRequest;
import org.konzerra.springex6.domain.auth.dto.AuthResponse;
import org.konzerra.springex6.domain.auth.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("public/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest request
    ){
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
