package com.sip.gestibanque.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sip.gestibanque.entities.Banque;
import com.sip.gestibanque.entities.CompteBancaire;

public interface CompteRepository extends CrudRepository<CompteBancaire, Integer> {

}
