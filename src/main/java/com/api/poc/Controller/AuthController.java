package com.api.poc.Controller;


import com.api.poc.Security.CustomUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userDetailsService;

    public AuthController(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestParam String username, @RequestParam String password) {
        userDetailsService.registerUser(username, password);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestParam String username, @RequestParam String password) {
        String token = userDetailsService.authenticateUser(username, password);
        return ResponseEntity.ok(token);
    }
}
