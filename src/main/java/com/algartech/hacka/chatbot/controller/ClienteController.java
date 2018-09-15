package com.algartech.hacka.chatbot.controller;

import com.algartech.hacka.chatbot.model.Cliente;
import com.algartech.hacka.chatbot.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pauloho on 15/09/18.
 */
@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Cliente> findAll(){
        return service.findAll();
    };

    @RequestMapping(value = "/findByCPF/{cpf}", method = RequestMethod.GET)
    public Cliente findByCPF(@PathVariable("cpf") String cpf){
        return  service.findByCPF(cpf);
    };


}

