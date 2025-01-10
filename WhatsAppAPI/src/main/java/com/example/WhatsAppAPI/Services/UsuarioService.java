package com.example.WhatsAppAPI.Services;

import com.example.WhatsAppAPI.Entity.Usuario;
import com.example.WhatsAppAPI.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarios(Long id){
        return usuarioRepository.findById(id);
    }

    public void saveOrUpdate(Usuario usuario){

        if (usuario.getNombre() == null || usuario.getCelular() == null) {
            throw new IllegalArgumentException("Nombre y celular son obligatorios.");
        }
        usuarioRepository.save(usuario);
    }
    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }
}
