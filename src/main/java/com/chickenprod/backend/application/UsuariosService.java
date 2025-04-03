package com.chickenprod.backend.application;

import java.util.List;
import java.util.Optional;

import com.chickenprod.backend.domain.Usuarios;

public interface UsuariosService {
    public List<Usuarios> findAll();
    public Usuarios save(Usuarios usuario); 
    public Optional<Usuarios> findById(Long id);
    public Optional<Usuarios> update(Long id, Usuarios usuario);
    public Optional<Usuarios> delete(Long id);
}
