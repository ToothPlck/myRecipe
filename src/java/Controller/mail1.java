package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Ayeshmi
 */
public class mail1 {

    public static void sendmail(String recepient, String body) throws Exception {
        System.out.println("mail sending started");
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        String name = "recipeesa@gmail.com";
        String password = "recipe123";

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(name, password);
            }
        });
        System.out.println("mail sending started1");
        // Message message=properMessage(session,name,recepient);  
        try {
            // Transport.send(message);
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(name));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("SOLUTIONS FOR YOUR PROBLEM.");
            message.setText(body);
            System.out.println("hello");

            try {
                Transport.send(message);
                System.out.println("mail sent");
            } catch (Exception e) {
                e.printStackTrace();
            }
            // System.out.println("mail sent");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
