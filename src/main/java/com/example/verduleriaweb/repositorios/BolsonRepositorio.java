package com.example.verduleriaweb.repositorios;

import com.example.verduleriaweb.entidades.Bolson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolsonRepositorio extends JpaRepository<Bolson, String> {
}
