package com.chickenprod.backend.infrastructure.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chickenprod.backend.application.ReportesProduccionService;
import com.chickenprod.backend.domain.ReportesProduccion;
import com.chickenprod.backend.domain.ReportesProduccionId;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RequestMapping("api/reportes-produccion")
@RestController
public class ReportesProduccionController {

    @Autowired
    private ReportesProduccionService reportesProduccion;

    @GetMapping
    public List<ReportesProduccion> findAll() {
        return reportesProduccion.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable ReportesProduccionId id) {
        return reportesProduccion.findById(id)
                .map(response -> ResponseEntity.ok(response))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ReportesProduccion newReportesProduccion,
            BindingResult bindingResult) {
        return bindingResult.hasFieldErrors()
                ? validation(bindingResult)
                : ResponseEntity.status(HttpStatus.CREATED).body(reportesProduccion.save(newReportesProduccion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable ReportesProduccionId id, @Valid @RequestBody ReportesProduccion newReportesProduccion,
            BindingResult bindingResult) {
        return bindingResult.hasFieldErrors()
                ? validation(bindingResult)
                : reportesProduccion.update(id, newReportesProduccion)
                        .map(response -> ResponseEntity.ok(response))
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ReportesProduccionId id) {
        return reportesProduccion.delete(id)
                .map(response -> ResponseEntity.ok(response))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<?> validation(BindingResult bindingResult) {
        Map<String, String> errors = bindingResult.getFieldErrors().stream()
                .collect(Collectors.toMap(
                        error -> error.getField(),
                        error -> "el campo" + error.getField() + " " + error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
}
