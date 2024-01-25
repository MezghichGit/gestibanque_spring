package com.sip.gestibanque.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sip.gestibanque.entities.Banque;

public interface CompteRepository extends CrudRepository<Banque, Integer> {

}
