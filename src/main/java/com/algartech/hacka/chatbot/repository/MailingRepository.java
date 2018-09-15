package com.algartech.hacka.chatbot.repository;


import com.algartech.hacka.chatbot.model.Mailing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by pauloho on 15/09/18.
 */
@Repository
public interface MailingRepository extends MongoRepository<Mailing, Integer> {


    public List<Mailing> findByCpf(String cpf);


}