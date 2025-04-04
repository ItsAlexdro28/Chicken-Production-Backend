package com.chickenprod.backend.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chickenprod.backend.domain.ConfiguracionesUsuario;

@Repository
public interface ConfiguracionesUsuarioRepository extends JpaRepository<ConfiguracionesUsuario, Long> {  
}
