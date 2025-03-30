package com.chickenprod.backend.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ReportesProduccionId implements Serializable {
	@Column(name = "produccion_id")
	private Long idProduccion;

	@Column(name = "analisis_id")
	private Long idAnalisis;

}
