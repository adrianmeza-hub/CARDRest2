package com.ibm.academia.apirest.services;


import java.util.Optional;

import com.ibm.academia.apirest.entities.Card;

public interface CardDAO extends GenericDAO<Card>{
	public Optional<Card> findById(Integer id);
	public Iterable<Card> bringNameCard(String pasion, int edad, int salario);

}
