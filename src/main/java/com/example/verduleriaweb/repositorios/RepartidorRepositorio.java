package com.example.verduleriaweb.repositorios;

import com.example.verduleriaweb.entidades.Repartidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepartidorRepositorio extends JpaRepository<Repartidor, String> {
}
