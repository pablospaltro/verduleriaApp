package com.example.verduleriaweb.repositorios;

import com.example.verduleriaweb.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

    public Usuario findByEmail(String email);

    Optional<Usuario> findByUsername(String username);


}
