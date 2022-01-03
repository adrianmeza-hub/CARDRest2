package com.ibm.academia.apirest.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.entities.Passion;
import com.ibm.academia.apirest.repositories.PassionRepository;

@Service
public class PassionDAOImpl extends GenericDAOImpl<Passion, PassionRepository> implements PassionDAO
{

	public PassionDAOImpl(PassionRepository repository) {
		super(repository);
		
	}

	@Override
	public Optional<Passion> findByNombreContainsIgnoreCase(String nombre) {
		
		return repository.findByNombreContainsIgnoreCase(nombre);
	}

}
                  