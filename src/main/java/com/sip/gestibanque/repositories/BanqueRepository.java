package com.sip.gestibanque.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.gestibanque.entities.Banque;

@Repository
public interface BanqueRepository extends CrudRepository<Banque, Integer> {

	// Ici on hérite implicitement les 10 méthodes du crudRepository
	// On peut également ajouter/enrichir ce repo par d'autres méthodes

	List<Banque> findByNom(String nom);

}
