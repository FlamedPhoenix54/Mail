package me.Mythical83.Mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public static String toEmail = "artinger.tb@gmail.com";
    public static String fromEmail = "artinger.tb@gmail.com";
    public static String password = "Tytyf1ghter512";
    public static String subject = "";
    public static String body = "";

    public static void main(String[]args) {

        try {
            Properties prop = new Properties();
            prop.setProperty("mail.smtp.host", "smtp.gmail.com");
            prop.setProperty("mail.smtp.port", "465");
            prop.setProperty("mail.smtp.auth", "true");
            prop.setProperty("mail.smtp.socketFactory.port", "465");
            prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));

            InternetAddress address = new InternetAddress("artinger.tb@gmail.com");

            msg.setRecipient(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setText(body);

            Transport.send(msg);

            System.out.println("Email sent successfully");

        } catch (Exception e) {

        }
    }
}
