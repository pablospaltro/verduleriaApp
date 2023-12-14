package com.example.verduleriaweb.entidades;

import com.example.verduleriaweb.enumeradores.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue
    private String id;

    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;
}
