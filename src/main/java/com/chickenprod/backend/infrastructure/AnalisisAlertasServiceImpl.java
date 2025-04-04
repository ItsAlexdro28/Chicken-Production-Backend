package com.chickenprod.backend.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chickenprod.backend.application.AnalisisAlertasService;
import com.chickenprod.backend.domain.AnalisisAlertas;
import com.chickenprod.backend.infrastructure.repository.AnalisisAlertasRepository;

@Service
public class AnalisisAlertasServiceImpl implements AnalisisAlertasService {

    @Autowired
    private AnalisisAlertasRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<AnalisisAlertas> findAll() {
        return (List<AnalisisAlertas>) repository.findAll();
    }

    @Override
    @Transactional
    public AnalisisAlertas save(AnalisisAlertas analisis) {
        AnalisisAlertas analisisDb = new AnalisisAlertas();
        analisisDb.setUsuarios(analisis.getUsuarios());
        analisisDb.setFecha(analisis.getFecha());
        analisisDb.setTipoAnalisis(analisis.getTipoAnalisis());
        analisisDb.setDescripcion(analisis.getDescripcion());
        return repository.save(analisisDb);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AnalisisAlertas> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<AnalisisAlertas> update(Long id, AnalisisAlertas analisis) {
        Optional<AnalisisAlertas> analisisInstance = repository.findById(id);
        if (analisisInstance.isPresent()) {
            AnalisisAlertas analisisDb = analisisInstance.get();
            analisisDb.setUsuarios(analisis.getUsuarios());
            analisisDb.setFecha(analisis.getFecha());
            analisisDb.setTipoAnalisis(analisis.getTipoAnalisis());
            analisisDb.setDescripcion(analisis.getDescripcion());

            return Optional.of(repository.save(analisisDb));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<AnalisisAlertas> delete(Long id) {
        Optional<AnalisisAlertas> analisisInstance = this.findById(id);
        if (analisisInstance.isPresent()) {
            analisisInstance.orElseThrow();
            return Optional.of(repository.save(analisisInstance.orElseThrow()));
        }
        return Optional.empty();
    }
}
