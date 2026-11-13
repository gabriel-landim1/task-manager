package com.landim.api_task_manager.service;

import com.landim.api_task_manager.entity.Usuario;
import com.landim.api_task_manager.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encotrado !"));
    }

    public Usuario insert(Usuario obj){
        return usuarioRepository.save(obj);
    }

    public Usuario update(Usuario obj, Long id){
        findById(id);
        Usuario usuario = new Usuario();

        usuario.setId(id);
        usuario.setNome(obj.getNome());
        usuario.setEmail(obj.getEmail());
        usuario.setSenha(obj.getSenha());

        return usuarioRepository.save(usuario);
    }

    public void delete(Long id){
        findById(id);
        usuarioRepository.deleteById(id);
    }
}