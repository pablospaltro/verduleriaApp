package com.example.verduleriaweb.seguridad.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    String username;
    String password;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
}
