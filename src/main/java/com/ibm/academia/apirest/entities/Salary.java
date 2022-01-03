package com.ibm.academia.apirest.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@Entity
@Table(name = "salarios")
public class Salary implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "salario", columnDefinition = "int4range")
	private String salario;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pasion_id")
	private Passion pasion;	
	
	@ManyToMany(fetch = FetchType.LAZY)
	
	@JoinTable(
			name = "salarios_edades_tarjetas",
			joinColumns = @JoinColumn(name = "salario_id"),
			inverseJoinColumns = @JoinColumn(name = "tarjetas_id")
	)
	@JsonIgnore
	private Set<Card> tarjetas; 
	
	@ManyToMany(fetch = FetchType.LAZY)	
	@JoinTable(
			name = "salarios_edades_tarjetas",			
			joinColumns = @JoinColumn(name = "salario_id"),					
			inverseJoinColumns = @JoinColumn(name = "edades_id")
	)
	
	@JsonIgnore
	private Set<Age> edades; 

	private static final long serialVersionUID = 6195493876627397318L;	

}
