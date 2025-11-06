package org.example.eMail;


import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class emailSender {

    private static final String emailFrom = "tomasjedno.noreply@gmail.com";
    private static final String emailTo = "matus.klimko@student.upjs.sk";
    private static final String appPassword = "djsv akwy biqp tcyr";

    public static void main(String[] args) throws MessagingException, IOException {
        int i = 0;
        while (i != 15) {

            Message message = new MimeMessage(getEmailSession());
            message.setFrom(new InternetAddress(emailFrom));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
            message.setSubject("jebem ti mater");

//            BodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setText("attachment test");
//
//            MimeBodyPart attachmentPart = new MimeBodyPart();
//            attachmentPart.attachFile(new File("src/main/resources/qrCodesGenerated/540678.png"));
//
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messageBodyPart);
//            multipart.addBodyPart(attachmentPart);
//
//            message.setContent(multipart);

            message.setText("""
                    lubim ta
                    ked sa na teba pozriem
                    moja laska k tebe je nekonecna
                    ahhhhhh
                    matusko""");
            Transport.send(message);
            System.out.println("email sent, cislo: " + (i + 1));
            i++;
        }
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
