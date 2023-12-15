package com.example.verduleriaweb.controladores;

import com.example.verduleriaweb.entidades.Usuario;
import com.example.verduleriaweb.response.ResponseHandlerObject;
import com.example.verduleriaweb.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro")
public class UsuarioControlador {


    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/usuario/vertodos")
    public List<Usuario> VerTodosUsuarios() {
        return usuarioServicio.verUsuariosTodos();
    }

    @GetMapping("/usuario/ver/{id}")
    public ResponseEntity<Object> verUsuarioPorId(@PathVariable("id") String id) {
        return ResponseHandlerObject.responseBuilder("Aqui estan los datos del usuario solicitado.", HttpStatus.OK, usuarioServicio.verUsuarioPorID(id));
    }


    @PostMapping("/usuario/guardar")
    public ResponseEntity<Object> guardarNuevoUsuario(@RequestBody Usuario usuario){
        try{
            return ResponseHandlerObject.responseBuilder("Operación exitosa, usuario guardado.", HttpStatus.CREATED, usuarioServicio.registrar(usuario.getNombre(), usuario.getApellido(), usuario.getDni(), usuario.getEmail(), usuario.getPassword()));
        } catch (Exception e){
            usuario = null;
            return ResponseHandlerObject.responseBuilder("Datos incorrectos.", HttpStatus.BAD_REQUEST, usuario);
        }
    }


    @PutMapping("/usuario/actualizar/id/{id}")
    public ResponseEntity<Object> actualizarUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuarioActualizado){
        try{
            usuarioServicio.actualizar(usuarioActualizado.getId(), usuarioActualizado.getNombre(), usuarioActualizado.getApellido(), usuarioActualizado.getDni(), usuarioActualizado.getEmail(), usuarioActualizado.getPassword());
            return ResponseHandlerObject.responseBuilder("Operación exitosa, usuario actualizado.", HttpStatus.OK, usuarioActualizado);
        } catch (Exception e){
            usuarioActualizado = null;
            return ResponseHandlerObject.responseBuilder("No se encontró el usuario.", HttpStatus.NOT_FOUND, usuarioActualizado);
        }
    }


    @DeleteMapping("/bibliotecario/eliminar/id/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable("id") String id){
        Usuario usuario = usuarioServicio.verUsuarioPorID(id).get();
        try{
            usuarioServicio.eliminarUsuario(id);
            return ResponseHandlerObject.responseBuilder("Operación exitosa, usuario eliminado.", HttpStatus.OK, usuario);
        } catch (Exception e){

            return ResponseHandlerObject.responseBuilder("No se encontró el usuario.", HttpStatus.NOT_FOUND, usuario);
        }
    }
}
