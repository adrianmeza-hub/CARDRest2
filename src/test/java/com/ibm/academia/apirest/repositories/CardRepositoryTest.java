package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.data.DatosDummy;
import com.ibm.academia.apirest.entities.Card;

@DataJpaTest
public class CardRepositoryTest 
{
	@Autowired
	private CardRepository cardRepository;
	
	@Test
	@DisplayName("Test1")
	void findById() 
	{
		//Given
		cardRepository.save(DatosDummy.card01());
		
		//When
		Optional<Card> expected =  cardRepository.findById(1);
		if(!expected.isPresent());
			//System.out.println("La tarjeta no existe");
		
		//Then
		assertThat(expected.get().equals(expected)==false);
	
	}
}
