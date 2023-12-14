package com.example.verduleriaweb.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Usuario {

    private String direccion;
    private String telefono;


}
