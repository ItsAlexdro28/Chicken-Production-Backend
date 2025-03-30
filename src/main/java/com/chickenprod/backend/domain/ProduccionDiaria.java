package com.chickenprod.backend.domain;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "produccion_diaria")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class ProduccionDiaria {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produccion_id")
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne

	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "cantidad")
	private int cantidad;

	@OneToMany (fetch = FetchType.LAZY, mappedBy = "produccion_diaria")
	private List<ReportesProduccion> reportesProduccion;

}
