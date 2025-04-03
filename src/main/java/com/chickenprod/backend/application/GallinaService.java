package com.chickenprod.backend.application;

import java.util.List;
import java.util.Optional;

import com.chickenprod.backend.domain.Gallina;

public interface GallinaService {
    public List<Gallina> findAll();
    public Gallina save(Gallina gallina); 
    public Optional<Gallina> findById(Long id);
    public Optional<Gallina> update(Long id, Gallina gallina);
    public Optional<Gallina> delete(Long id);
}
