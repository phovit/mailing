package com.algartech.hacka.chatbot.jobs;

import com.algartech.hacka.chatbot.model.Mailing;
import com.algartech.hacka.chatbot.service.EmailService;
import com.algartech.hacka.chatbot.service.MailingService;
import com.algartech.hacka.chatbot.service.SmsService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pauloho on 10/09/18.
 */
public class MailingJob implements Job {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SmsService sms;

    @Autowired
    private EmailService mail;

    @Autowired
    private MailingService service;


    public void execute(JobExecutionContext context)
            throws JobExecutionException {

        for (Mailing mailing : service.getAtrasados()) {

            try {

                String conteudo = "Olá " + mailing.getNom_clien() + ". Nós da ChatBotGrupoF verificamos em nosso sistemas que consta um Saldo de " + mailing.getVal_princ() + " em aberto.\n" +
                        "Acesse o link abaixo para verificar as formas de negociação.\n" +
                        "\n" +
                        "https://t.me/JaoNegociadorBot";
                mail.sendEmail(mail.generateToken(mail.generateGrantCode()), "Campanha Cliente Legal", conteudo, mailing.getDes_email());

                conteudo = "Olá. Nós da ChatBotGrupoF verificamos que consta um Saldo de R$" + mailing.getVal_princ() + " em aberto." +
                        " Acesse o link para ajudarmos nesta situação." +
                        " https://t.me/JaoNegociadorBot";
                sms.sendSms(mailing.getDes_phone_1(), mailing.getCpf(), conteudo);

                logger.info("Notificação enviada com sucesso!");

            } catch (Exception e) {
                //do nothing
            }
        }

    }

}
