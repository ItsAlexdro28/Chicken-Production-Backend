package com.chickenprod.backend.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chickenprod.backend.application.GallinaService;
import com.chickenprod.backend.domain.Gallina;
import com.chickenprod.backend.infrastructure.repository.GallinaRepository;

@Service
public class GallinaServiceImpl implements GallinaService {
    
    @Autowired
    private GallinaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Gallina> findAll() {
        return (List<Gallina>) repository.findAll();
    }

    @Override
    @Transactional
    public Gallina save(Gallina gallina) {
        Gallina gallinaDb = new Gallina();
        gallinaDb.setNombre(gallina.getNombre());
        gallinaDb.setFechaNacimiento(gallina.getFechaNacimiento());
        gallinaDb.setEstado(gallina.getEstado());
        gallinaDb.setGrupo(gallina.getGrupo());
        return repository.save(gallinaDb);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Gallina> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Gallina> update(Long id, Gallina gallina) {
        Optional<Gallina> gallinaInstance = repository.findById(id);
        if (gallinaInstance.isPresent()) {
            Gallina gallinaDb = gallinaInstance.get();
            gallinaDb.setNombre(gallina.getNombre());
            gallinaDb.setFechaNacimiento(gallina.getFechaNacimiento());
            gallinaDb.setEstado(gallina.getEstado());
            gallinaDb.setGrupo(gallina.getGrupo());

            return Optional.of(repository.save(gallinaDb));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Gallina> delete(Long id) {
        Optional<Gallina> gallinaInstance = this.findById(id);
        if (gallinaInstance.isPresent()) {
            gallinaInstance.orElseThrow();
            return Optional.of(repository.save(gallinaInstance.orElseThrow()));
        }
        return Optional.empty();
    }
}
