package com.example.verduleriaweb.repositorios;

import com.example.verduleriaweb.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepositorio extends JpaRepository<Administrador, String> {
}
