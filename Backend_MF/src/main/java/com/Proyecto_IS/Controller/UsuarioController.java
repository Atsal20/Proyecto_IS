package com.Proyecto_IS.Controller;

import com.Proyecto_IS.Entidades.Usuario;
import com.Proyecto_IS.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> registerUser(@Validated @RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.registerUser(usuario);
        if(savedUsuario == null) {
            return new ResponseEntity<Usuario>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Usuario>(savedUsuario, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> loginUser(@Validated @RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.loginUser(usuario);
        if(savedUsuario == null) {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Usuario>(savedUsuario, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Usuario> updateUser(@Validated @RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.updateUser(usuario);
        if(savedUsuario == null) {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Usuario>(savedUsuario, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Usuario> deleteUser(@Validated @RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.deleteUser(usuario);
        if(savedUsuario == null) {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Usuario>(savedUsuario, HttpStatus.OK);
    }
}
