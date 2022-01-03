package com.ibm.academia.apirest.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.ibm.academia.apirest.entities.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer>{
	public Optional<Card> findById(Integer id);
		
	@Query(value="select * from salarios_edades_tarjetas se "
			+ "inner join salarios s on s.id= se.salario_id "
			+ "inner join edades e on e.id= se.edades_id "
			+ "inner join tarjetas t on t.id= se.tarjetas_id "
			+ "inner join pasiones p on p.id = s.pasion_id "
			+ "where upper(p.nombre) like %:pasion% "
			+ "and e.edad  @> :edad "
			+ "and s.salario @> :salario limit 1", nativeQuery = true)
	
	public Iterable<Card> bringNameCard(@Param("pasion")String pasion,@Param("edad")int edad,@Param("salario")int salario);
}

