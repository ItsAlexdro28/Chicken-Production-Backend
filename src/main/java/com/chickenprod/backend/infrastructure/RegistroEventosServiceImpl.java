package com.chickenprod.backend.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chickenprod.backend.application.RegistroEventosService;
import com.chickenprod.backend.domain.RegistroEventos;
import com.chickenprod.backend.infrastructure.repository.RegistroEventosRepository;

@Service
public class RegistroEventosServiceImpl implements RegistroEventosService {

    @Autowired
    private RegistroEventosRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<RegistroEventos> findAll() {
        return (List<RegistroEventos>) repository.findAll();
    }

    @Override
    @Transactional
    public RegistroEventos save(RegistroEventos evento) {
        RegistroEventos eventoDb = new RegistroEventos();
        eventoDb.setUsuarios(evento.getUsuarios());
        eventoDb.setDescripcion(evento.getDescripcion());
        eventoDb.setFecha(evento.getFecha());
        return repository.save(eventoDb);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RegistroEventos> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<RegistroEventos> update(Long id, RegistroEventos evento) {
        Optional<RegistroEventos> eventoInstance = repository.findById(id);
        if (eventoInstance.isPresent()) {
            RegistroEventos eventoDb = eventoInstance.get();
            eventoDb.setUsuarios(evento.getUsuarios());
            eventoDb.setDescripcion(evento.getDescripcion());
            eventoDb.setFecha(evento.getFecha());

            return Optional.of(repository.save(eventoDb));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<RegistroEventos> delete(Long id) {
        Optional<RegistroEventos> eventoInstance = this.findById(id);
        if (eventoInstance.isPresent()) {
            eventoInstance.orElseThrow();
            return Optional.of(repository.save(eventoInstance.orElseThrow()));
        }
        return Optional.empty();
    }
}
