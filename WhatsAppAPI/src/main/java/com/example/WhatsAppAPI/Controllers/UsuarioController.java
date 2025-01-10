package com.example.WhatsAppAPI.Controllers;

import com.example.WhatsAppAPI.Entity.Usuario;
import com.example.WhatsAppAPI.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAll(){
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getBId(@PathVariable("id")Long Id){
        return usuarioService.getUsuarios(Id);
    }

    @PostMapping
    public ResponseEntity<String> saveUpdate(@RequestBody Usuario usuario){
        usuarioService.saveOrUpdate(usuario);
        return ResponseEntity.ok("Usuario guardado correctamente");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long Id){
        usuarioService.delete(Id);
    }

}
