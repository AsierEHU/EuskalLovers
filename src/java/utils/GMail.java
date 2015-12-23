package utils;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
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
    private final String username = "euskallovers@gmail.com";
    private final String password = "euskallover";

    private GMail() {
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }

    public static GMail getMail() {
        if (mail == null) {
            mail = new GMail();
        }
        return mail;
    }

    public void enviarMensaje(String nick, String correo, String subject, String texto) {
        Session sessionMail = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message msg = new MimeMessage(sessionMail);
            msg.setFrom(new InternetAddress("euskallovers@gmail.com", "EuskalLovers"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(correo, nick));
            msg.setSubject(subject);
            msg.setText(texto);
            Transport.send(msg);

        } catch (AddressException e) {
        } catch (MessagingException | UnsupportedEncodingException e) {
        }
    }

}
