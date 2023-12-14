package com.example.verduleriaweb.entidades;

import com.example.verduleriaweb.enumeradores.DiaDeEntrega;
import com.example.verduleriaweb.enumeradores.MetodoDePago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue
    private String id;

    @Enumerated(EnumType.STRING)
    private DiaDeEntrega dia;
    private String horario;
    @OneToMany
    private ArrayList<Bolson> bolsones;
    private double precioTotal;
    @OneToOne
    private Cliente cliente;
    private MetodoDePago metodo;
    private boolean estaPago;





}
