package com.chickenprod.backend.application;

import java.util.List;
import java.util.Optional;

import com.chickenprod.backend.domain.ReportesProduccion;
import com.chickenprod.backend.domain.ReportesProduccionId;

public interface ReportesProduccionService {
    public List<ReportesProduccion> findAll();
    public ReportesProduccion save(ReportesProduccion reportesProduccion); 
    public Optional<ReportesProduccion> findById(ReportesProduccionId id);
    public Optional<ReportesProduccion> update(ReportesProduccionId id, ReportesProduccion reportesProduccion);
    public Optional<ReportesProduccion> delete(ReportesProduccionId id);
}
