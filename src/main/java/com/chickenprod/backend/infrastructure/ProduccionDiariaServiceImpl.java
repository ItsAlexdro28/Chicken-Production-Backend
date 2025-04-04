package com.chickenprod.backend.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chickenprod.backend.application.ProduccionDiariaService;
import com.chickenprod.backend.domain.ProduccionDiaria;
import com.chickenprod.backend.infrastructure.repository.ProduccionDiariaRepository;

@Service
public class ProduccionDiariaServiceImpl implements ProduccionDiariaService {

    @Autowired
    private ProduccionDiariaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<ProduccionDiaria> findAll() {
        return (List<ProduccionDiaria>) repository.findAll();
    }

    @Override
    @Transactional
    public ProduccionDiaria save(ProduccionDiaria produccion) {
        ProduccionDiaria produccionDb = new ProduccionDiaria();
        produccionDb.setGallina(produccion.getGallina());
        produccionDb.setFecha(produccion.getFecha());
        produccionDb.setCantidad(produccion.getCantidad());
        return repository.save(produccionDb);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProduccionDiaria> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<ProduccionDiaria> update(Long id, ProduccionDiaria produccion) {
        Optional<ProduccionDiaria> produccionInstance = repository.findById(id);
        if (produccionInstance.isPresent()) {
            ProduccionDiaria produccionDb = produccionInstance.get();
            produccionDb.setGallina(produccion.getGallina());
            produccionDb.setFecha(produccion.getFecha());
            produccionDb.setCantidad(produccion.getCantidad());
            return Optional.of(repository.save(produccionDb));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<ProduccionDiaria> delete(Long id) {
        Optional<ProduccionDiaria> produccionInstance = this.findById(id);
        if (produccionInstance.isPresent()) {
            repository.delete(produccionInstance.get());
            return produccionInstance;
        }
        return Optional.empty();
    }
}
