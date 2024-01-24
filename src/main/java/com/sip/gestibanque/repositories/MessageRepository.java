package com.sip.gestibanque.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.gestibanque.entities.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer>{

}
