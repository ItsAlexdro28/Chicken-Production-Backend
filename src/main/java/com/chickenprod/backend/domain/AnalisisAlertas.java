package com.chickenprod.backend.domain;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "analisis_alerta")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class AnalisisAlertas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "analisis_id")
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("id")
	@JoinColumn(name = "usuario_id")
	private Usuarios usuarios;

	@CreationTimestamp
	private Timestamp fecha;

	@Enumerated(EnumType.STRING)
	private TipoAnalisis tipoAnalisis;

	@Column(name = "descripcion")
	private String descripcion;

	//@JsonIgnore
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "analisisAlertas")
	private List<ReportesProduccion> reportesProduccion;
}

