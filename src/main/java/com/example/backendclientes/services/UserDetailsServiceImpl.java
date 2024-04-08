package com.example.backendclientes.services;

import com.example.backendclientes.model.Usuario;
import com.example.backendclientes.repository.IUsuarioDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUsuarioDAO usuarioRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con username: " + username));
        logger.debug("Contraseña almacenada para {}: {}", username, usuario.getPassword());  // Log para depuración
        return UserDetailsImpl.build(usuario);
    }
}
