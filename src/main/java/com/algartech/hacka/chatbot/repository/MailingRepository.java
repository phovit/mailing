package com.algartech.hacka.chatbot.repository;


import com.algartech.hacka.chatbot.model.Mailing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pauloho on 15/09/18.
 */
@Repository
public interface MailingRepository extends MongoRepository<Mailing, Integer> {


}