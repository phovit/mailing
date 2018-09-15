package com.algartech.hacka.chatbot.service;

import com.algartech.hacka.chatbot.model.Cliente;
import com.algartech.hacka.chatbot.model.Mailing;
import com.algartech.hacka.chatbot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pauloho on 15/09/18.
 */
@Service
public class ClienteService {


    @Autowired
    private ClienteRepository repository;


    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findByCPF(String cpf) {

        return repository.findByCpf(cpf);
    }


    public void insertOrUpdateByMailing(Mailing mailing) {
        Cliente cli = new Cliente();

        cli.setTip_reg(mailing.getTip_reg());
        cli.setCod_siste(mailing.getCod_siste());
        cli.setDat_movto(mailing.getDat_movto());
        cli.setTip_inter(mailing.getTip_inter());
        cli.setCod_credor(mailing.getCod_credor());
        cli.setDes_regis(mailing.getDes_regis());
        cli.setInd_alter(mailing.getInd_alter());
        cli.setDes_cpf(mailing.getCpf());
        cli.setNom_clien(mailing.getNom_clien());
        cli.setDat_nasci(mailing.getDat_nasci());
        cli.setDes_ender_resid(mailing.getDes_ender_resid());
        cli.setDes_numer_resid(mailing.getDes_numer_resid());
        cli.setDes_compl_resid(mailing.getDes_compl_resid());
        cli.setDes_bairr_resid(mailing.getDes_bairr_resid());
        cli.setDes_cidad_resid(mailing.getDes_cidad_resid());
        cli.setDes_estad_resid(mailing.getDes_estad_resid());
        cli.setDes_phone_1(mailing.getDes_phone_1());
        cli.setDes_phone_2(mailing.getDes_phone_2());
        cli.setDes_email(mailing.getDes_email());
        repository.save(cli);

    }
}
