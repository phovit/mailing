package com.algartech.hacka.chatbot.repository;


import com.algartech.hacka.chatbot.model.Cliente;
import com.algartech.hacka.chatbot.model.Mailing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pauloho on 15/09/18.
 */
@Repository
public interface ClienteRepository extends MongoRepository<Cliente, Integer> {

    //@Query("{ 'des_cpf' : ?0 }")
    public Cliente findByCpf(String cpf);


}