package com.Proyecto_IS.Controller;

import com.Proyecto_IS.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping("/login")
     public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
     }
}
