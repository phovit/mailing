package com.algartech.hacka.chatbot.config;

/**
 * Created by pauloho on 15/09/18.
 */

import com.algartech.hacka.chatbot.model.Mailing;
import com.algartech.hacka.chatbot.repository.MailingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@EnableMongoRepositories(basePackageClasses = MailingRepository.class)
@Configuration
public class MongoConfig {
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");


    @Bean
    CommandLineRunner commandLineRunner(MailingRepository mailingRepository) {


        try {
            Mailing cli1 = new Mailing("1", "01", new java.util.Date(format.parse("20180910").getTime()), "1", "1", "39891408841", "1", "39891408841", "AMANDA CRISTINA RUSTICI BALSAMO", new java.util.Date(format.parse("19940313").getTime()), "LIBERDADE", "557", "CD RES URUPES BL 02 AP 202", "COPACABANA", "UBERLANDIA", "MG", "11950110188", "12976019056", "rafaels@algartech.com", "3", "TELECOM", "000343467291", new java.util.Date(format.parse("20180307").getTime()), "0000000000000000000242089895/2", new java.util.Date(format.parse("20180221").getTime()), null, new BigDecimal(00000000000068.1900), "1");
            Mailing cli2 = new Mailing("1", "01", new java.util.Date(format.parse("20180910").getTime()), "1", "1", "36060615600", "1", "36060615600", "ANTONIO LOURENCO CORREA", new java.util.Date(format.parse("19560420").getTime()), "AMAZONAS", "43", "", "CENTRO", "LAGAMAR", "MG", "12976019086", "12976019102", "karlosgc@algartech.com", "3", "TELECOM", "000001190156", new java.util.Date(format.parse("20180307").getTime()), "0000000000000000000242131323/2", new java.util.Date(format.parse("20180221").getTime()), null, new BigDecimal(00000000000024.6700), "1");
            Mailing cli3 = new Mailing("1", "01", new java.util.Date(format.parse("20180910").getTime()), "1", "1", "36060615600", "1", "36060615600", "ANTONIO LOURENCO CORREA", new java.util.Date(format.parse("19560420").getTime()), "AMAZONAS", "43", "", "CENTRO", "LAGAMAR", "MG", "12976019086", "12976019102", "karlosgc@algartech.com", "3", "TELECOM", "000424562200", new java.util.Date(format.parse("20180511").getTime()), "0000000000000000000247043116/2", new java.util.Date(format.parse("20180421").getTime()), null, new BigDecimal(00000000000039.0700), "1");
            return strings -> {
                mailingRepository.save(cli1);
                mailingRepository.save(cli2);
                mailingRepository.save(cli3);
            };
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

}