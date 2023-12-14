package com.example.verduleriaweb.entidades;


import com.example.verduleriaweb.enumeradores.TipoDeBolson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bolson {

    @Id
    @GeneratedValue
    private String id;

    @Enumerated(EnumType.STRING)
    protected TipoDeBolson tipo;

    protected int precio;
}
