package com.chickenprod.backend.application;

import java.util.List;
import java.util.Optional;

import com.chickenprod.backend.domain.ProduccionDiaria;

public interface ProduccionDiariaService {
    public List<ProduccionDiaria> findAll();
    public ProduccionDiaria save(ProduccionDiaria produccionDiaria); 
    public Optional<ProduccionDiaria> findById(Long id);
    public Optional<ProduccionDiaria> update(Long id, ProduccionDiaria produccionDiaria);
    public Optional<ProduccionDiaria> delete(Long id);
}
