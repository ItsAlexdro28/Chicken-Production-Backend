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

import com.chickenprod.backend.application.ResumenProduccionService;
import com.chickenprod.backend.domain.ResumenProduccion;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("api/services")
@RestController
public class ResumenProduccionController {

    @Autowired
    private ResumenProduccionService resumenProduccion;

    @GetMapping
    public List<ResumenProduccion> findAll() {
        return resumenProduccion.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return resumenProduccion.findById(id)
                .map(response -> ResponseEntity.ok(response))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> save(@PathVariable Long id, @Valid @RequestBody ResumenProduccion newResumenProduccion,
            BindingResult bindingResult) {
        return bindingResult.hasFieldErrors()
                ? validation(bindingResult)
                : ResponseEntity.status(HttpStatus.CREATED).body(resumenProduccion.save(newResumenProduccion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ResumenProduccion newResumenProduccion,
            BindingResult bindingResult) {
        return bindingResult.hasFieldErrors()
                ? validation(bindingResult)
                : resumenProduccion.update(id, newResumenProduccion)
                        .map(response -> ResponseEntity.ok(response))
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return resumenProduccion.delete(id)
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
