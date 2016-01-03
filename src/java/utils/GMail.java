package utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author docencia
 */
public class GMail {

    private static GMail mail;
    private final Properties props;
    private final String from = "euskallovers@gmail.com";
    private final String username = "euskallovers@gmail.com";
    private final String password = "euskallover";

    private GMail() {
        props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
        
         props.put("mail.imap.ssl.enable", "true"); // required for Gmail
 props.put("mail.imap.auth.mechanisms", "XOAUTH2");
// Session session = Session.getInstance(props);
// Store store = session.getStore("imap");
// store.connect("imap.gmail.com", username, oauth2_access_token);
        
               props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.auth", "true");
 props.put("mail.smtp.port", "465");

    }

    public static GMail getMail() {
        if (mail == null) {
            mail = new GMail();
        }
        return mail;
    }

    public void enviarMensaje(String correo, String subject, String texto) throws MessagingException {

        javax.mail.Session sessionMail = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

            Message msg = new MimeMessage(sessionMail);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            msg.setSubject(subject);
            msg.setText(texto);
            Transport.send(msg);

    }

}
