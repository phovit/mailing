package com.algartech.hacka.chatbot.service;

import com.algartech.hacka.chatbot.jobs.MailingJob;
import com.algartech.hacka.chatbot.model.Mailing;
import com.algartech.hacka.chatbot.repository.MailingRepository;
import org.apache.commons.lang3.StringUtils;
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    public String findConsolidatedByCPF(String cpf) {
        Mailing mailing = new Mailing();
        mailing.setCpf(cpf);
        mailing.setVal_princ(new BigDecimal(0));

        List<Mailing> mailings = repository.findByCpf(cpf);

        for (Mailing ml : mailings) {
            mailing.setNom_clien(ml.getNom_clien());
            mailing.setVal_princ(mailing.getVal_princ().add(ml.getVal_princ()));
            if (mailing.getDat_venci() == null || mailing.getDat_venci().compareTo(ml.getDat_venci()) < 0) {
                mailing.setDat_venci(ml.getDat_venci());
            }
        }

        String txtReturn = "Sua dívida atual é de R$" + getValorAvista(mailing) + " para pagamento à vista e R$ " + getValorAPrazo(mailing) + " para pagamento parcelado.\n" +
                "Como deseja pagar sua dívida?";


        return txtReturn;
    }

    private String getValorAPrazo(Mailing mailing) {

        int diasAtraso = new Date().compareTo(mailing.getDat_venci());
        int diasDesprezo = 0;
        Double taxa = 0D;

        if (diasAtraso >= 5 && diasAtraso <= 21) {
            diasDesprezo = 0;
            taxa = 12D;
        } else if (diasAtraso >= 5 && diasAtraso <= 21) {
            diasDesprezo = 30;
            taxa = 12D;

        } else if (diasAtraso >= 61 && diasAtraso <= 81) {
            diasDesprezo = 60;
            taxa = 12D;

        } else if (diasAtraso >= 91 && diasAtraso <= 111) {
            diasDesprezo = 90;
            taxa = 4.99D;

        } else if (diasAtraso >= 121 && diasAtraso <= 141) {
            diasDesprezo = 120;
            taxa = 4.99D;

        } else if (diasAtraso >= 151 && diasAtraso <= 171) {
            diasDesprezo = 150;
            taxa = 4.99D;

        } else if (diasAtraso >= 181 && diasAtraso <= 201) {
            diasDesprezo = 180;
            taxa = 4.99D;

        } else if (diasAtraso >= 211 && diasAtraso <= 231) {
            diasDesprezo = 210;
            taxa = 4.99D;

        } else if (diasAtraso >= 241 && diasAtraso <= 261) {
            diasDesprezo = 240;
            taxa = 4.99D;

        } else if (diasAtraso >= 271 && diasAtraso <= 291) {
            diasDesprezo = 270;
            taxa = 4.99D;

        } else if (diasAtraso >= 301 && diasAtraso <= 321) {
            diasDesprezo = 300;
            taxa = 4.99D;

        } else if (diasAtraso >= 331 && diasAtraso <= 351) {
            diasDesprezo = 330;
            taxa = 4.99D;

        } else {
            diasDesprezo = 0;
            taxa = 0D;
        }
        Double valora = (Double) mailing.getVal_princ().doubleValue() * (taxa / 100 + 1);
        Double valorB = Double.valueOf(diasAtraso - diasDesprezo);

        Double valorFinal = Math.pow(valora, valorB);
        return valorFinal.toString();
    }

    private String getValorAvista(Mailing mailing) {


        int diasAtraso = new Date().compareTo(mailing.getDat_venci());
        int diasDesprezo = 0;
        Double taxa = 0D;
        int desconto = 0;

        if (diasAtraso >= 40 && diasAtraso <= 60) {
            desconto = 5;
        } else if (diasAtraso >= 61 && diasAtraso <= 90) {
            desconto = 15;

        } else if (diasAtraso >= 91 && diasAtraso <= 120) {
            desconto = 20;

        } else if (diasAtraso >= 121 && diasAtraso <= 180) {
            desconto = 25;

        } else if (diasAtraso >= 181 && diasAtraso <= 270) {
            desconto = 35;

        } else if (diasAtraso >= 271 && diasAtraso <= 360) {
            desconto = 50;

        } else if (diasAtraso >= 361 && diasAtraso <= 540) {
            desconto = 75;

        } else if (diasAtraso >= 541 && diasAtraso <= 720) {
            desconto = 75;

        } else if (diasAtraso >= 721 && diasAtraso <= 1080) {
            desconto = 80;

        } else if (diasAtraso >= 1081 && diasAtraso <= 1800) {
            desconto = 90;

        } else if (diasAtraso >= 1801 && diasAtraso <= 2520) {
            desconto = 95;

        } else if (diasAtraso >= 2521) {
            desconto = 95;

        } else {
            desconto = 0;
        }
        return String.valueOf(round(mailing.getVal_princ().subtract(mailing.getVal_princ().multiply(new BigDecimal(desconto / 100))),2));
    }

    public static double round(BigDecimal bd1, int scale) {
        BigDecimal bd2 = bd1.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return bd2.doubleValue();
    }

}
