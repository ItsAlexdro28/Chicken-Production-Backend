package com.chickenprod.backend.application;

import java.util.List;
import java.util.Optional;

import com.chickenprod.backend.domain.ResumenProduccion;

public interface ResumenProduccionService {
    public List<ResumenProduccion> findAll();
    public ResumenProduccion save(ResumenProduccion resumenProduccion); 
    public Optional<ResumenProduccion> findById(Long id);
    public Optional<ResumenProduccion> update(Long id, ResumenProduccion resumenProduccion);
    public Optional<ResumenProduccion> delete(Long id);
}
