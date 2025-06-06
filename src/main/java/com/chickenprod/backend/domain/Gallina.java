package com.chickenprod.backend.domain;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.chickenprod.backend.domain.Grupo;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "gallina")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Gallina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "gallina_id")
	private Integer id;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado", nullable = false)
	private Estado estado = Estado.ACTIVO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grupo_id")
	private Grupo grupo;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gallina")
	private List<ProduccionDiaria> produccionDiaria;

}
