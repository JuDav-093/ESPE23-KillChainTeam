/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.evsustore.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */
public class EmailUtils {
    public static void sendRecoveryEmail(String recipient, String subject, String body) throws MessagingException {
        final String fromEmail = "kiboki1234@hotmail.com";
        final String hotmailPassword = "Badineire1234";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");

        MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        CommandMap.setDefaultCommandMap(mc);

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, hotmailPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(body, "text/plain");

            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp-mail.outlook.com", fromEmail, hotmailPassword);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            throw new MessagingException("Error al enviar el correo electrónico: " + e.getMessage());
        }
    }
    
   public static void sendEmailWithAttachment(String recipient, String subject, String body, String attachmentPath) throws MessagingException {
        final String fromEmail = "kiboki1234@hotmail.com";
        final String hotmailPassword = "Badineire1234";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");

        MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        CommandMap.setDefaultCommandMap(mc);

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, hotmailPassword);
            }
        });

                try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(body, "text/plain");

        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(attachmentPath);

        // Create a unique file name based on timestamp
        String uniqueFileName = generateUniqueFileName(attachmentPath);

        attachmentBodyPart.setDataHandler(new DataHandler(source));
        attachmentBodyPart.setFileName(uniqueFileName);

        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
        multipart.addBodyPart(attachmentBodyPart);

        message.setContent(multipart);

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp-mail.outlook.com", fromEmail, hotmailPassword);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            throw new MessagingException("Error al enviar el correo electrónico: " + e.getMessage());
        }
    }
   
    private static String generateUniqueFileName(String originalFileName) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());
        int dotIndex = originalFileName.lastIndexOf(".");
        String extension = "";
        if (dotIndex > 0) {
            extension = originalFileName.substring(dotIndex);
        }
        return "factura_" + timestamp + extension;
    }
}