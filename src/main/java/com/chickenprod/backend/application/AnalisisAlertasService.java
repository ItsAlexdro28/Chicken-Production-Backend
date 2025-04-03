package com.chickenprod.backend.application;

import java.util.List;
import java.util.Optional;

import com.chickenprod.backend.domain.AnalisisAlertas;

public interface AnalisisAlertasService {
    public List<AnalisisAlertas> findAll();
    public AnalisisAlertas save(AnalisisAlertas analisisAlertas); 
    public Optional<AnalisisAlertas> findById(Long id);
    public Optional<AnalisisAlertas> update(Long id, AnalisisAlertas analisisAlertas);
    public Optional<AnalisisAlertas> delete(Long id);
}
