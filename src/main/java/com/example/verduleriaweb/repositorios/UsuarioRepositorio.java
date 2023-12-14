package com.example.verduleriaweb.repositorios;

import com.example.verduleriaweb.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

    public Usuario findByEmail(String email);
}
