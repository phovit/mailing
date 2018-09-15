package com.algartech.hacka.chatbot.controller;

import com.algartech.hacka.chatbot.model.EmailDTO;
import com.algartech.hacka.chatbot.model.GenericRequestDTO;
import com.algartech.hacka.chatbot.model.Mailing;
import com.algartech.hacka.chatbot.model.ResponseDTO;
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

/**
 * Created by pauloho on 15/09/18.
 */
@RestController
@RequestMapping("mailing")
public class MailingController {
    private Double valorRetorno = 1563.64D;

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
    public ResponseDTO findByCPF(@PathVariable("cpf") String cpf){

        //return  new ResponseDTO( service.findConsolidatedByCPF(cpf));
        return new ResponseDTO("Entendi. " +
                "Sua dívida atual é de R$1.563,64 para pagamento à vista e R$1.676,37 para pagamento parcelado. " +
                "Como deseja pagar sua dívida?");
    };

    @RequestMapping(value = "/negociacao", method = RequestMethod.POST)
    public ResponseDTO formaNegociacao(@RequestBody GenericRequestDTO view){
        return service.getTextNegociacao(view.getString());
    }

    @RequestMapping(value = "/setTypeNegociation", method = RequestMethod.POST)
    public ResponseDTO tipoNegociacao(@RequestBody GenericRequestDTO view) {
        return new ResponseDTO("Vai ser moleza! Para darmos seguimento na nossa negociação, qual o valor ideal para a entrada?");
    }

    @RequestMapping(value = "/sendValueIncome", method = RequestMethod.POST)
    public ResponseDTO valorEntrada(@RequestBody GenericRequestDTO view) {

        Double valor = valorRetorno -  view.getValor();
        return new ResponseDTO("Entendi! O saldo da conta é R$"+valor+".  E agora qual é o valor ideal para as parcelas? Lembrando que o valor mínimo é de 20 reais!");
    }

    @RequestMapping(value = "/sendValueParc", method = RequestMethod.POST)
    public ResponseDTO valorParcelas(@RequestBody GenericRequestDTO view) {
        String retorno = "";
        Double saldo = valorRetorno %  view.getValor();


        Double qtdParcelas = (valorRetorno - saldo)/ view.getValor();

        retorno = "Esse valor é possível! Então serão "+qtdParcelas+" parcelas de R$"+view.getValor()+". ";
        if(saldo>0){
            retorno += " E mais uma de R$" + saldo;
        }
        retorno += ". Aceita essas condições?";

        return new ResponseDTO(retorno);

    }



    @RequestMapping(value = "/sendAccept", method = RequestMethod.POST)
    public ResponseDTO aceite(@RequestBody GenericRequestDTO view) {

        return new ResponseDTO("Que bom! Qual é a melhor data para iniciar a pagar?");
    }

    @RequestMapping(value = "/sendDataPayment", method = RequestMethod.POST)
    public ResponseDTO dataNegociacao(@RequestBody GenericRequestDTO view) {

        return new ResponseDTO("Deseja receber os códigos de barras por SMS?");
    }



    @RequestMapping(value = "/sendSMS", method = RequestMethod.POST)
    public ResponseDTO enviaSms(@RequestBody GenericRequestDTO view) {

        new SmsService().sendSms("34988657231", "10700342664", "00000.00000. 00000.000000 00000.000000 0 00000000000000");
        return new ResponseDTO("Perfeito! Muito Obrigado!");
    }




}

