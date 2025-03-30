package com.chickenprod.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class ReportesProduccion {

	@EmbeddedId
	@Column(name = "reporte_id")
	@EqualsAndHashCode.Include
	private ReportesProduccionId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("analisisId")
	@JoinColumn(name = "analisis_id")
	private AnalisisAlertas analisisAlertas;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("produccionId")
	@JoinColumn(name = "produccion_id")
	private ProduccionDiaria produccionDiaria;
}
