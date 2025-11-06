package org.example.eMail;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static org.example.eMail.emailConstants.*;

public class emailSender {

    private static final String emailFrom = APP_MAIL;
    private static final String emailTo = "matus.klimko@student.upjs.sk";
    private static final String appPassword = EMAIL_APP_PASS;

    public static void main(String[] args) throws MessagingException, IOException {


        Message message = new MimeMessage(getEmailSession());
        message.setFrom(new InternetAddress(emailFrom));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
        message.setSubject("Registrácia");

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Registrácia úspešná");

        MimeBodyPart attachmentPart = new MimeBodyPart();
        attachmentPart.attachFile(new File("src/main/resources/qrCodesGenerated/540678.png"));

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachmentPart);

        message.setContent(multipart);

        Transport.send(message);
        System.out.println("email sent");


    }

    private static Session getEmailSession() {
        return Session.getInstance(getEmailProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailFrom, appPassword);
            }
        });
    }

    private static Properties getEmailProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        return properties;
    }

}
