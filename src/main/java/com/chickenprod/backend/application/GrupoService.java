package com.chickenprod.backend.application;

import java.util.List;
import java.util.Optional;

import com.chickenprod.backend.domain.Grupo;

public interface GrupoService {
    public List<Grupo> findAll();
    public Grupo save(Grupo grupo); 
    public Optional<Grupo> findById(Long id);
    public Optional<Grupo> update(Long id, Grupo grupo);
    public Optional<Grupo> delete(Long id);
}
