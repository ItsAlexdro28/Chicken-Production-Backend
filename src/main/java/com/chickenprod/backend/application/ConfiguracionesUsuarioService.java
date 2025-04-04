package com.chickenprod.backend.application;

import java.util.List;
import java.util.Optional;

import com.chickenprod.backend.domain.ConfiguracionesUsuario;

public interface ConfiguracionesUsuarioService {
    public List<ConfiguracionesUsuario> findAll();
    public ConfiguracionesUsuario save(ConfiguracionesUsuario configuracionesUsuario); 
    public Optional<ConfiguracionesUsuario> findById(Long id);
    public Optional<ConfiguracionesUsuario> update(Long id, ConfiguracionesUsuario configuracionesUsuario);
    public Optional<ConfiguracionesUsuario> delete(Long id);
}
