package com.algartech.hacka.chatbot.repository;


import com.algartech.hacka.chatbot.model.Fatura;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pauloho on 15/09/18.
 */
@Repository
public interface FaturaRepository extends MongoRepository<Fatura, Integer> {


}