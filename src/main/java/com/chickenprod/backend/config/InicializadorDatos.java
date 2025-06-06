package com.chickenprod.backend.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import com.chickenprod.backend.domain.Grupo;
import com.chickenprod.backend.infrastructure.repository.GrupoRepository;

import java.sql.Date;

@Configuration
public class InicializadorDatos {

    @Bean
	@Order(Ordered.LOWEST_PRECEDENCE)
    public CommandLineRunner initData(GrupoRepository grupoRepository) {
        return args -> {
            if (!grupoRepository.existsById(1L)) {
                Grupo grupo = new Grupo();
                grupo.setNombre("Originales");
                grupo.setDescripcion("Grupo inicial donde estan todas las gallinas");
                grupo.setFechaCreacion(new Date(System.currentTimeMillis()));
                grupoRepository.save(grupo);
            }
        };
    }
}
