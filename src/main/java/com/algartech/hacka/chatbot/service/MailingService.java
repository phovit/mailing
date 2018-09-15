package com.algartech.hacka.chatbot.service;

import com.algartech.hacka.chatbot.jobs.MailingJob;
import com.algartech.hacka.chatbot.model.Mailing;
import com.algartech.hacka.chatbot.repository.MailingRepository;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.br.CPF;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by pauloho on 15/09/18.
 */
@Service
public class MailingService {


    @Autowired
    private MailingRepository repository;
    @Autowired
    private ClienteService clientService;

    public static void scheduleMailing() {


        JobDetail job = JobBuilder.newJob(MailingJob.class)
                .withIdentity("mailingjob", "Mailing").build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("mailingtrigger", "Mailing")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 1 ? * * *"))
                .build();


        Scheduler scheduler = null;
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    public List<Mailing> findAll() {
        return repository.findAll();
    }


    public void importFile(String filename) {


        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        try {
            FileReader arq = new FileReader(filename);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();

            while (linha != null) {


                String[] value = linha.split(";");

                Mailing mailing = new Mailing();
                mailing.setTip_reg(value[0]);
                mailing.setCod_siste(value[1]);
                try {
                    mailing.setDat_movto(new java.util.Date(format.parse(value[2]).getTime()));
                } catch (Exception e) {

                }
                mailing.setTip_inter(value[3]);
                mailing.setCod_credor(value[4]);
                mailing.setDes_regis(value[5]);
                mailing.setInd_alter(value[6]);
                mailing.setCpf(value[7]);
                mailing.setNom_clien(value[8]);
                try {
                    mailing.setDat_nasci(new java.util.Date(format.parse(value[9]).getTime()));
                } catch (Exception e) {

                }
                mailing.setDes_ender_resid(value[10]);
                mailing.setDes_numer_resid(value[11]);
                mailing.setDes_compl_resid(value[12]);
                mailing.setDes_bairr_resid(value[13]);
                mailing.setDes_cidad_resid(value[14]);
                mailing.setDes_estad_resid(value[15]);
                mailing.setDes_phone_1(value[16]);
                mailing.setDes_phone_2(value[17]);
                mailing.setDes_email(value[18]);
                mailing.setTip_inter_fatura(value[19]);
                mailing.setCod_produt(value[20]);
                mailing.setDes_contr(value[21]);
                try {
                    mailing.setDat_venci(new java.util.Date(format.parse(value[21]).getTime()));
                } catch (Exception e) {

                }
                mailing.setNum_prest(value[23]);
                try {
                    mailing.setDat_corre(new java.util.Date(format.parse(value[24]).getTime()));
                } catch (Exception e) {

                }
                try {
                    mailing.setDat_pagam(new java.util.Date(format.parse(value[25]).getTime()));
                } catch (Exception e) {

                }
                String valor = StringUtils.leftPad(value[26], 18, "0");
                valor = valor.substring(0, 14) + "." + valor.substring(14);
                mailing.setVal_princ(new BigDecimal(valor));
                mailing.setInd_alter_fatura(value[27]);

                clientService.insertOrUpdateByMailing(mailing);
                repository.save(mailing);
                linha = lerArq.readLine();
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

    }


    public String findConsolidatedByCPF(String cpf){
        Mailing mailing = new Mailing();
        mailing.setCpf(cpf);
        mailing.setVal_princ(new BigDecimal(0));

        List<Mailing> mailings = repository.findByCpf(cpf);

        for(Mailing ml : mailings){
            mailing.setNom_clien(ml.getNom_clien());
            mailing.setVal_princ( mailing.getVal_princ().add(ml.getVal_princ()) );
            if(mailing.getDat_venci() == null || mailing.getDat_venci().compareTo(ml.getDat_venci())<0){
                mailing.setDat_venci(ml.getDat_venci());
            }
        }

        String txtReturn = "Sua dívida atual é de R$"+getValorAvista(mailing) +" para pagamento à vista e R$ "+getValorAPrazo(mailing) +" para pagamento parcelado.\n" +
                "Como deseja pagar sua dívida?";


        return txtReturn;
    }

    private String getValorAvista(Mailing mailing) {

        return mailing.getVal_princ().toString();
    }

    private String getValorAPrazo(Mailing mailing) {
        return mailing.getVal_princ().toString();
    }

}
