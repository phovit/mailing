package com.algartech.hacka.chatbot.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pauloho on 15/09/18.
 */
public class SmsService {




    public String sendSms(String phone, String cpf, String text ) {


        try {

            URL url = new URL("http://api.maisresultado.com.br/sms2/pgsms.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "text/xml");
            conn.setRequestProperty("SOAPAction", "envioAvulso");


            Format formatter;
            Date date = new Date();
            formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String input =
                    "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:PGSMS\">\n" +
                            "    <soapenv:Header/>\n" +
                            "    <soapenv:Body>\n" +
                            "        <urn:envioAvulso>\n" +
                            "            <urn:token>e5e2de7f3ef2043b664c121bd22f853c</urn:token>\n" +
                            "            <urn:carteira>CR341000070</urn:carteira>\n" +
                            "            <urn:msg>"+text+"</urn:msg>\n" +
                            "            <urn:fones>"+phone+"</urn:fones>\n" +
                            "            <urn:data>"+formatter.format(date)+"</urn:data>\n" +
                            "            <urn:dadocliente>"+cpf+"</urn:dadocliente>\n" +
                            "        </urn:envioAvulso>\n" +
                            "    </soapenv:Body>\n" +
                            "</soapenv:Envelope>";


            System.out.println(input);
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                return output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }catch (Exception e) {

            e.printStackTrace();

        }
        return "";


    }

}
