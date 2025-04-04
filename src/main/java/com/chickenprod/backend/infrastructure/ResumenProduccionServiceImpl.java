package com.chickenprod.backend.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chickenprod.backend.application.ResumenProduccionService;
import com.chickenprod.backend.domain.ResumenProduccion;
import com.chickenprod.backend.infrastructure.repository.ResumenProduccionRepository;

@Service
public class ResumenProduccionServiceImpl implements ResumenProduccionService {
    
    @Autowired
    private ResumenProduccionRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<ResumenProduccion> findAll() {
        return (List<ResumenProduccion>) repository.findAll();
    }

    @Override
    @Transactional
    public ResumenProduccion save(ResumenProduccion resumen) {
        ResumenProduccion resumenDb = new ResumenProduccion();
        resumenDb.setGrupo(resumen.getGrupo());
        resumenDb.setFecha(resumen.getFecha());
        resumenDb.setTotalHuevos(resumen.getTotalHuevos());
        return repository.save(resumenDb);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ResumenProduccion> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<ResumenProduccion> update(Long id, ResumenProduccion resumen) {
        Optional<ResumenProduccion> resumenInstance = repository.findById(id);
        if (resumenInstance.isPresent()) {
            ResumenProduccion resumenDb = resumenInstance.get();
            resumenDb.setGrupo(resumen.getGrupo());
            resumenDb.setFecha(resumen.getFecha());
            resumenDb.setTotalHuevos(resumen.getTotalHuevos());

            return Optional.of(repository.save(resumenDb));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<ResumenProduccion> delete(Long id) {
        Optional<ResumenProduccion> resumenInstance = this.findById(id);
        if (resumenInstance.isPresent()) {
            resumenInstance.orElseThrow();
            return Optional.of(repository.save(resumenInstance.orElseThrow()));
        }
        return Optional.empty();
    }
}
