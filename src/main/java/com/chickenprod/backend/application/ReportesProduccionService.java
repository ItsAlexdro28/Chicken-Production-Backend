package com.chickenprod.backend.application;

import java.util.List;
import java.util.Optional;

import com.chickenprod.backend.domain.ReportesProduccion;

public interface ReportesProduccionService {
    public List<ReportesProduccion> findAll();
    public ReportesProduccion save(ReportesProduccion reportesProduccion); 
    public Optional<ReportesProduccion> findById(Long id);
    public Optional<ReportesProduccion> update(Long id, ReportesProduccion reportesProduccion);
    public Optional<ReportesProduccion> delete(Long id);
}
