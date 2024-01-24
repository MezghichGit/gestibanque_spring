package com.sip.gestibanque.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.gestibanque.entities.Banque;

@Repository
public interface BanqueRepository extends CrudRepository<Banque, Integer>{
	
	// ici on hérite implicitement les 10 méthodes du crudRepository
	// on peut également ajouter/enrichir ce repo par d'autres méthodes

}
