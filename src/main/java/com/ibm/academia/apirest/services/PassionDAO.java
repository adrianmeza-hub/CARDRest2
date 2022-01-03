package com.ibm.academia.apirest.services;

import java.util.Optional;

import com.ibm.academia.apirest.entities.Passion;

public interface PassionDAO extends GenericDAO<Passion>{
	 public Optional<Passion> findByNombreContainsIgnoreCase(String nombre);
}
