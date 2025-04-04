package com.chickenprod.backend.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chickenprod.backend.application.GrupoService;
import com.chickenprod.backend.domain.Grupo;
import com.chickenprod.backend.infrastructure.repository.GrupoRepository;

@Service
public class GrupoServiceImpl implements GrupoService {
    
    @Autowired
    private GrupoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Grupo> findAll() {
        return (List<Grupo>) repository.findAll();
    }

    @Override
    @Transactional
    public Grupo save(Grupo grupo) {
        Grupo grupoDb = new Grupo();
        grupoDb.setNombre(grupo.getNombre());
        grupoDb.setDescripcion(grupo.getDescripcion());
        grupoDb.setFechaCreacion(grupo.getFechaCreacion());
        return repository.save(grupoDb);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Grupo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Grupo> update(Long id, Grupo grupo) {
        Optional<Grupo> grupoInstance = repository.findById(id);
        if (grupoInstance.isPresent()) {
            Grupo grupoDb = grupoInstance.get();
            grupoDb.setNombre(grupo.getNombre());
            grupoDb.setDescripcion(grupo.getDescripcion());
            grupoDb.setFechaCreacion(grupo.getFechaCreacion());

            return Optional.of(repository.save(grupoDb));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Grupo> delete(Long id) {
        Optional<Grupo> grupoInstance = this.findById(id);
        if (grupoInstance.isPresent()) {
            grupoInstance.orElseThrow();
            return Optional.of(repository.save(grupoInstance.orElseThrow()));
        }
        return Optional.empty();
    }
}
