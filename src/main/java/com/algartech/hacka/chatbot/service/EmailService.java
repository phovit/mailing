package com.algartech.hacka.chatbot.service;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by pauloho on 15/09/18.
 */
public class EmailService {

    public String generateGrantCode() {
        try {

            URL url = new URL("https://hlg-algartech.sensedia.com/oauth/grant-code");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\n" +
                    "\t\"client_id\":\"6620c2ea-eb5e-316b-91a0-df4947592dd8\",\n" +
                    "\t\"redirect_uri\":\"https://hlg-algartech.sensedia.com/oauth\"\n" +
                    "}";

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
                //System.out.println(output);
                return output.substring(output.indexOf("code=")+5).replace("\"}","");
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return "";
    }

    public String generateToken(String grantCode) {
        try {

            URL url = new URL("https://hlg-algartech.sensedia.com/oauth/access-token");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            String encoded = Base64.getEncoder().encodeToString(
                    ("6620c2ea-eb5e-316b-91a0-df4947592dd8" + ":" + "70c76382-886d-3c60-ac73-10a094fac7a8").getBytes(StandardCharsets.UTF_8));
            conn.setRequestProperty("Authorization", "Basic " + encoded);

            String input = "{\n" +
                    "\t\"code\": \"" + grantCode + "\",\n" +
                    "\t\"grant_type\": \"urn:ietf:params:oauth:grant-type:jwt-bearer\"\n" +
                    "}";

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

                JSONObject jsonObj = new JSONObject(output);
                return jsonObj.getString("access_token");
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

    public String sendEmail(String token, String assunto, String conteudo, String email ) {


        try {

            URL url = new URL("https://hlg-algartech.sensedia.com/broker-email-hacka/email");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("access_token", token);

            String input =
                    "{\"subject\":\""+assunto+"\","+
                    "\"text\":\""+conteudo+"\","+
                    "\"email\":\""+email+"\"}";

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
