package com.example.backendclientes.controllers;

import com.example.backendclientes.auth.JwtResponse;
import com.example.backendclientes.auth.JwtUtil;
import com.example.backendclientes.auth.LoginRequest;
import com.example.backendclientes.model.Usuario;
import com.example.backendclientes.repository.IUsuarioDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    IUsuarioDAO usuarioRepository;
    @Autowired
    JwtUtil jwtUtils;
    @Autowired
    PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        logger.debug("Intento de login con username: {} y password: {}", loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken(authentication);
        System.out.println("Mi bonito JWT al fin"+ jwt );
        return ResponseEntity.ok(new JwtResponse(jwt));


    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody Usuario signUpRequest) {
        if (usuarioRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: El nombre de usuario ya está en uso.");
        }

        // Crear un nuevo usuario
        Usuario user = new Usuario();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setEnabled(true);
        usuarioRepository.save(user);
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

}

