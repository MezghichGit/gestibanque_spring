package com.sip.gestibanque.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.gestibanque.entities.Message;
import java.time.LocalDate;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {

	List<Message> findByDateMessage(LocalDate dateMessage);
}
