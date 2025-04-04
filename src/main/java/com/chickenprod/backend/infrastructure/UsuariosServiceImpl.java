package com.chickenprod.backend.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chickenprod.backend.application.UsuariosService;
import com.chickenprod.backend.domain.Usuarios;
import com.chickenprod.backend.infrastructure.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    
    @Autowired
    private UsuariosRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> findAll() {
        return (List<Usuarios>) repository.findAll();
    }

    @Override
    @Transactional
    public Usuarios save(Usuarios usuario) {
        Usuarios usuarioDb = new Usuarios();
        usuarioDb.setNombre(usuario.getNombre());
        usuarioDb.setEmail(usuario.getEmail());
        usuarioDb.setContraseña(usuario.getContraseña());
        usuarioDb.setPerfil(usuario.getPerfil());
        return repository.save(usuarioDb);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuarios> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Usuarios> update(Long id, Usuarios usuario) {
        Optional<Usuarios> usuarioInstance = repository.findById(id);
        if (usuarioInstance.isPresent()) {
            Usuarios usuarioDb = usuarioInstance.get();
            usuarioDb.setNombre(usuario.getNombre());
            usuarioDb.setEmail(usuario.getEmail());
            usuarioDb.setContraseña(usuario.getContraseña());
            usuarioDb.setPerfil(usuario.getPerfil());
            
            return Optional.of(repository.save(usuarioDb));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Usuarios> delete(Long id) {
        Optional<Usuarios> usuarioInstance = this.findById(id);
        if (usuarioInstance.isPresent()) {
            usuarioInstance.orElseThrow();
            return Optional.of(repository.save(usuarioInstance.orElseThrow()));
        }
        return Optional.empty();
    }
}
