package com.chickenprod.backend.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chickenprod.backend.application.ConfiguracionesUsuarioService;
import com.chickenprod.backend.domain.ConfiguracionesUsuario;
import com.chickenprod.backend.infrastructure.repository.ConfiguracionesUsuarioRepository;

@Service
public class ConfiguracionesUsuarioServiceImpl implements ConfiguracionesUsuarioService {

    @Autowired
    private ConfiguracionesUsuarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<ConfiguracionesUsuario> findAll() {
        return (List<ConfiguracionesUsuario>) repository.findAll();
    }

    @Override
    @Transactional
    public ConfiguracionesUsuario save(ConfiguracionesUsuario configuracion) {
        ConfiguracionesUsuario configDb = new ConfiguracionesUsuario();
        configDb.setUsuarios(configuracion.getUsuarios());
        configDb.setNotificaciones(configuracion.getNotificaciones());
        configDb.setTema(configuracion.getTema());
        return repository.save(configDb);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ConfiguracionesUsuario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<ConfiguracionesUsuario> update(Long id, ConfiguracionesUsuario configuracion) {
        Optional<ConfiguracionesUsuario> configInstance = repository.findById(id);
        if (configInstance.isPresent()) {
            ConfiguracionesUsuario configDb = configInstance.get();
            configDb.setUsuarios(configuracion.getUsuarios());
            configDb.setNotificaciones(configuracion.getNotificaciones());
            configDb.setTema(configuracion.getTema());

            return Optional.of(repository.save(configDb));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<ConfiguracionesUsuario> delete(Long id) {
        Optional<ConfiguracionesUsuario> configInstance = this.findById(id);
        if (configInstance.isPresent()) {
            configInstance.orElseThrow();
            return Optional.of(repository.save(configInstance.orElseThrow()));
        }
        return Optional.empty();
    }
}
