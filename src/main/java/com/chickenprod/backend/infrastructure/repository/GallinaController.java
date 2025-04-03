package com.chickenprod.backend.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chickenprod.backend.domain.Gallina;

@Repository
public interface GallinaController extends JpaRepository<Gallina, Long> {  
}
