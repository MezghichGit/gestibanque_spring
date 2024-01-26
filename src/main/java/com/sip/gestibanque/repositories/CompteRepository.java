package com.sip.gestibanque.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.gestibanque.entities.CompteBancaire;

@Repository
public interface CompteRepository extends CrudRepository<CompteBancaire, Integer> {

	List<CompteBancaire> findByProprietaire(String proprietaire);

}
