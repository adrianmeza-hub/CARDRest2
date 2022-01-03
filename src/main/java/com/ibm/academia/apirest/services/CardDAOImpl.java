package com.ibm.academia.apirest.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.entities.Card;
import com.ibm.academia.apirest.entities.Passion;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.repositories.CardRepository;
@Service
public class CardDAOImpl extends GenericDAOImpl<Card, CardRepository>implements CardDAO
{

	public CardDAOImpl(CardRepository repository) 
	{
		super(repository);
	}

	@Override
	public Optional<Card> findById(Integer id) 
	{
		
		return repository.findById(id);
	}

	@Autowired
	private PassionDAO passionDAO;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Card> bringNameCard(String pasion, int edad, int salario) 
	{
		Optional<Passion> oPassion = passionDAO.findByNombreContainsIgnoreCase(pasion);
		
		if (!oPassion.isPresent())
		throw new NotFoundException(String.format("There is no such passion", pasion));
		else if(edad <18)
			throw new NotFoundException(String.format("You are not age", edad));
		else if(edad >80)
			throw new NotFoundException(String.format("Age must be less than 80 years old ", edad));
		else if(salario <7000)
		    throw new NotFoundException(String.format("The salary must be greater than $7000 ", salario));
		else if(salario >100000)
		    throw new NotFoundException(String.format("The salary must be less than $100000 ", salario));
	  
		
		return repository.bringNameCard(pasion, edad, salario);
		
	}

}
