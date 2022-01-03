package com.ibm.academia.apirest.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Passion;

@Repository
public interface PassionRepository extends CrudRepository<Passion, Integer> {
 public Optional<Passion> findByNombreContainsIgnoreCase(String nombre);
}
