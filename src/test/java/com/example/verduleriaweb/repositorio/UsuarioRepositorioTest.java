package com.example.verduleriaweb.repositorio;

import com.example.verduleriaweb.entidades.Usuario;
import com.example.verduleriaweb.repositorios.UsuarioRepositorio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UsuarioRepositorioTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    Usuario usuario1;

    @BeforeEach
    public void setUp() {
        usuario1 = new Usuario();
        usuario1.setEmail("leonel@messi.ar");
        entityManager.persist(usuario1);
    }

    @AfterEach
    void tearDown() {
        entityManager.clear();
    }

    @Test
    public void testFindByNombre_Found() {
        String email = "leonel@messi.ar";

        Usuario usuario2 = usuarioRepositorio.findByEmail(email);
        assertThat(usuario2).isNotNull();
        assertThat(usuario2.getEmail()).isEqualTo(email);
    }

}
