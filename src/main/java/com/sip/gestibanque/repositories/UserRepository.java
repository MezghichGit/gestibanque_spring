package com.sip.gestibanque.repositories;

import org.springframework.stereotype.Repository;

import com.sip.gestibanque.entities.User;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
