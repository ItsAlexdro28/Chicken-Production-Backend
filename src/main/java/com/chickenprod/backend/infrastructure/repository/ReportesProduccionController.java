package com.chickenprod.backend.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chickenprod.backend.domain.ReportesProduccion;
import com.chickenprod.backend.domain.ReportesProduccionId;

@Repository
public interface ReportesProduccionController extends JpaRepository<ReportesProduccion, ReportesProduccionId> {  
}
