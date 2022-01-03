package com.ibm.academia.apirest.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "edades")
public class Age implements Serializable
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "edad", columnDefinition = "int4range")
	private String edad;
	
	@ManyToMany(mappedBy = "edades", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Salary> salarios;
	
	private static final long serialVersionUID = 820139132099079465L;
	

}
