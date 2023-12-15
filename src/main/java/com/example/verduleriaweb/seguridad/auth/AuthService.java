package com.example.verduleriaweb.seguridad.auth;

import com.example.verduleriaweb.entidades.Usuario;
import com.example.verduleriaweb.enumeradores.Rol;
import com.example.verduleriaweb.repositorios.UsuarioRepositorio;
import com.example.verduleriaweb.seguridad.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {


        Usuario usuario = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .dni(request.getDni())
                .email(request.getEmail())
                .rol(Rol.USER)
                .build();

        usuarioRepositorio.save(usuario);

        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();

    }
}
