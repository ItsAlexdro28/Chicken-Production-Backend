package com.chickenprod.backend.domain;

import java.security.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "usuarios")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Usuarios {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	@EqualsAndHashCode.Include
	private Long id;

	@Column(length = 100)
	private String nombre;

	@Column(unique = true, length = 100)
	private String email;

	@Column(length = 255)
	private String contraseña;
	
	@Enumerated(EnumType.STRING)
	private Perfil perfil;

	@CreationTimestamp
	private Timestamp fecha_creacion;

	// TODO MANY to ONE relationships (configuraciones_usuarios, registro_eventos, analisis_alertas)
	//@JsonIgnore
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "service")
	//private List<ServiceApproval> serviceApprovalList;


}
