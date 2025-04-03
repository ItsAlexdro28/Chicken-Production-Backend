package com.chickenprod.backend.application;

import java.util.List;
import java.util.Optional;

import com.chickenprod.backend.domain.RegistroEventos;

public interface RegistroEventosService {
    public List<RegistroEventos> findAll();
    public RegistroEventos save(RegistroEventos registroEventos); 
    public Optional<RegistroEventos> findById(Long id);
    public Optional<RegistroEventos> update(Long id, RegistroEventos registroEventos);
    public Optional<RegistroEventos> delete(Long id);
}
