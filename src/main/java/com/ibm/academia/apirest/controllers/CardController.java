package com.ibm.academia.apirest.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.entities.Card;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.repositories.CardRepository;
import com.ibm.academia.apirest.services.CardDAOImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/card")
@Api(value = "Metodos relacionados con la Tarjeta", tags = "Acciones de tarjetas")
public class CardController 
{
	@Autowired
	private CardDAOImpl cardDaoImpl;
	
	@Autowired
	private CardRepository cardRepository;
	
	/**
	 * Endpoint para buscar un producto por id
	 * @return Retorna el id del producto
	 * @NotFoundException En caso de que no exista ese id
	 * @author Adrián Meza 22/12/2021
	 */
	
	@GetMapping("/id/{id}")
	public Optional<Card> buscarPorId(@PathVariable Integer id) 
	{
		Optional<Card> card = cardRepository.findById(id);
		
		if(!card.isPresent())
			throw new NotFoundException(String.format("El producto con el ID: %d no existe", id));
			
		return card;
	}
	
	/**
	 * Endpoint para listar las tarjetas
	 * @return Retorna una lista de tarjetas
	 * 	 * @NotFoundException En caso de que no existan tarjetas
	 * @author Adrián Meza 22/12/2021
	 */
	@GetMapping("/cardCredit")
	@ApiOperation(value = "Buscar tarjeta para dar seguimiento")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ejecutado satisfactoriamente") })
	public Iterable<Card>  findCard(@RequestParam String pasion, @RequestParam int edad, @RequestParam int salario)
	{
		
		Iterable<Card> card = cardDaoImpl.bringNameCard(pasion.toUpperCase(),edad,salario);	  
	  return card;
	 }
	
}
