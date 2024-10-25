package com.Proyecto_IS.Service;

import com.Proyecto_IS.Entidades.Usuario;
import com.Proyecto_IS.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registerUser(Usuario usuario) {
        usuario.setFechaRegistro(new Date());
        return usuarioRepository.save(usuario);
    }

    public Usuario loginUser(Usuario usuario) {
        Usuario savedUsuario = usuarioRepository.findByEmail(usuario.getEmail());
        if(savedUsuario == null) {
            return null;
        }
        if(!savedUsuario.getPassword().equals(usuario.getPassword())) {
            return null;
        }
        return savedUsuario;
    }

    public Usuario updateUser(Usuario usuario) {
        Usuario savedUsuario = usuarioRepository.findByEmail(usuario.getEmail());
        if(savedUsuario == null) {
           return null;
        }
        savedUsuario.setNombre(usuario.getNombre());
        savedUsuario.setApellidos(usuario.getApellidos());
        savedUsuario.setEmail(usuario.getEmail());
        savedUsuario.setPassword(usuario.getPassword());
        savedUsuario.setTelefono(usuario.getTelefono());
        savedUsuario.setDireccion(usuario.getDireccion());
        savedUsuario.setCiudad(usuario.getCiudad());
        savedUsuario.setCodigoPostal(usuario.getCodigoPostal());
        return usuarioRepository.save(savedUsuario);
    }
     public Usuario deleteUser(Usuario usuario) {
        Usuario savedUsuario = usuarioRepository.findByEmail(usuario.getEmail());
        if(savedUsuario == null) {
           return null;
        }
        usuarioRepository.delete(savedUsuario);
        return savedUsuario;
    }

    public Usuario getUserByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }







}
