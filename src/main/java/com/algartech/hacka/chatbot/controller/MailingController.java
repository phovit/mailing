package com.algartech.hacka.chatbot.controller;

import com.algartech.hacka.chatbot.model.EmailDTO;
import com.algartech.hacka.chatbot.model.Mailing;
import com.algartech.hacka.chatbot.model.SmsDTO;
import com.algartech.hacka.chatbot.service.EmailService;
import com.algartech.hacka.chatbot.service.MailingService;
import com.algartech.hacka.chatbot.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by pauloho on 15/09/18.
 */
@RestController
@RequestMapping("mailing")
public class MailingController {

    @Autowired
    private MailingService service;

    @RequestMapping(method = RequestMethod.POST)
    public void save(){

    };


    @RequestMapping(method = RequestMethod.GET)
    public List<Mailing> findAll(){
        return service.findAll();
    };

    @RequestMapping(value = "/importFile/{filename}", method = RequestMethod.GET)
    public void importFile(@PathVariable("filename")  String filename){
        service.importFile("/tmp/files/"+filename);
    };

    @RequestMapping(value = "/importFile", method = RequestMethod.POST)
    public void importFiles(@RequestParam String filename){
        service.importFile(filename);
    };


    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public void sendEmail(@RequestBody EmailDTO email ){
        String assunto = email.getAssunto();
        String conteudo = email.getConteudo();
        String texto  = email.getEmail();
        String grantCode = new EmailService().generateGrantCode();
        String token = new EmailService().generateToken(grantCode);
        new EmailService().sendEmail(token, assunto, conteudo,texto);
    }


    @RequestMapping(value = "/sendSms", method = RequestMethod.POST)
    public void sendSms(@RequestBody SmsDTO sms){

        new SmsService().sendSms(sms.getPhone(), sms.getCpf(), sms.getTexto());
    }

    @RequestMapping(value = "/dividas/{cpf}", method = RequestMethod.GET)
    public String findByCPF(@PathVariable("cpf") String cpf){
        return  service.findConsolidatedByCPF(cpf);
    };


}

