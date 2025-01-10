package com.example.WhatsAppAPI.Controllers;

import com.example.WhatsAppAPI.Entity.Estado;
import com.example.WhatsAppAPI.Services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> getAll(){
        return estadoService.getEstados();
    }

    @GetMapping("/{id}")
    public Optional<Estado> getBId(@PathVariable("id") Long id){
        return estadoService.getEstados(id);
    }

    @PostMapping
    public ResponseEntity<String> saveUpdate(@RequestBody Estado estado) {
        estadoService.saveOrUpdate(estado);
        return ResponseEntity.ok("Estado guardado correctamente");
    }

    @DeleteMapping("/{id}")
    public void saveUpdate(@PathVariable("id") Long id){
        estadoService.delete(id);
    }
}
