package com.sip.gestibanque.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sip.gestibanque.entities.CompteBancaire;

public interface CompteRepository extends CrudRepository<CompteBancaire, Integer> {

	List<CompteBancaire> findByProprietaire(String proprietaire);




 
}
