package com.example.verduleriaweb.servicios;

import com.example.verduleriaweb.entidades.Usuario;
import com.example.verduleriaweb.enumeradores.Rol;
import com.example.verduleriaweb.excepciones.MyException;
import com.example.verduleriaweb.excepciones.UsuarioNotFoundException;
import com.example.verduleriaweb.repositorios.UsuarioRepositorio;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;


    @Transactional
    public void registrar(String nombre, String apellido, String dni, String email, String password)
            throws MyException {

        validar(nombre, apellido, dni, email, password);

        Usuario usuario = new Usuario();

        usuario.setNombre(nombre);
        usuario.setEmail(email);

        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.PUBLICO);

        usuarioRepositorio.save(usuario);
    }

    public List<Usuario> verUsuariosTodos() {
        if (usuarioRepositorio.findAll().isEmpty())
            throw new UsuarioNotFoundException("No hay usuarios ingresados.");
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> verUsuarioPorID(String id) {
        if (usuarioRepositorio.findById(id).isEmpty())
            throw new UsuarioNotFoundException("El usuario solicitado no existe");
        return usuarioRepositorio.findById(id);
    }

    @Transactional
    public void actualizar(String idUsuario, String nombre, String apellido, String dni, String email, String password) throws MyException {

        validar(nombre, apellido, dni, email, password);

        Optional<Usuario> respuesta = usuarioRepositorio.findById(idUsuario);
        if (respuesta.isPresent()) {

            Usuario usuario = respuesta.get();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setDni(dni);
            usuario.setEmail(email);
            usuario.setPassword(new BCryptPasswordEncoder().encode(password));
            usuario.setRol(Rol.PUBLICO);

            usuarioRepositorio.save(usuario);
        }

    }

    private void validar(String nombre, String apellido, String dni, String email, String password) throws MyException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MyException("el nombre no puede ser nulo o estar vacío");
        }
        if (apellido.isEmpty() || apellido == null) {
            throw new MyException("el apellido no puede ser nulo o estar vacío");
        }
        if (dni.isEmpty() || dni == null) {
            throw new MyException("el dni no puede ser nulo o estar vacío");
        }
        if (email.isEmpty() || email == null) {
            throw new MyException("el email no puede ser nulo o estar vacio");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MyException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }
    }

    public void eliminarUsuario(String id) {
        usuarioRepositorio.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(email);

        if (usuario != null) {
            List<GrantedAuthority> permisos = new ArrayList();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
            permisos.add(p);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession", usuario);

            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
        } else {
            return null;
        }
    }
}
