package com.landim.api_task_manager.controller;

import com.landim.api_task_manager.entity.Usuario;
import com.landim.api_task_manager.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(usuarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> insert(@Valid @RequestBody Usuario obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.insert(obj));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@Valid @RequestBody Usuario obj, @PathVariable Long id){
        return ResponseEntity.ok().body(usuarioService.update(obj, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}