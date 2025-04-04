package com.chickenprod.backend.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chickenprod.backend.application.ReportesProduccionService;
import com.chickenprod.backend.domain.ReportesProduccion;
import com.chickenprod.backend.domain.ReportesProduccionId;
import com.chickenprod.backend.infrastructure.repository.ReportesProduccionRepository;

@Service
public class ReportesProduccionServiceImpl implements ReportesProduccionService {

    @Autowired
    private ReportesProduccionRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<ReportesProduccion> findAll() {
        return (List<ReportesProduccion>) repository.findAll();
    }

    @Override
    @Transactional
    public ReportesProduccion save(ReportesProduccion reporte) {
        ReportesProduccion reporteDb = new ReportesProduccion();
        reporteDb.setId(reporte.getId());
        reporteDb.setAnalisisAlertas(reporte.getAnalisisAlertas());
        reporteDb.setProduccionDiaria(reporte.getProduccionDiaria());
        return repository.save(reporteDb);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ReportesProduccion> findById(ReportesProduccionId id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<ReportesProduccion> update(ReportesProduccionId id, ReportesProduccion reporte) {
        Optional<ReportesProduccion> reporteInstance = repository.findById(id);
        if (reporteInstance.isPresent()) {
            ReportesProduccion reporteDb = reporteInstance.get();
            reporteDb.setAnalisisAlertas(reporte.getAnalisisAlertas());
            reporteDb.setProduccionDiaria(reporte.getProduccionDiaria());

            return Optional.of(repository.save(reporteDb));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<ReportesProduccion> delete(ReportesProduccionId id) {
        Optional<ReportesProduccion> reporteInstance = this.findById(id);
        if (reporteInstance.isPresent()) {
            reporteInstance.orElseThrow();
            return Optional.of(repository.save(reporteInstance.orElseThrow()));
        }
        return Optional.empty();
    }
}
