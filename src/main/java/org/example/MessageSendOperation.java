package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MessageSendOperation {

    private final ServerInformation serverInformation;
    private final SmtpUser user;

    private Session session;

    public MessageSendOperation(ServerInformation serverInformation, SmtpUser user) {
        this.serverInformation = serverInformation;
        this.user = user;
    }

    public void createSession() {
        if (session != null) {
            throw new IllegalStateException("Session is already created.");
        }
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", String.valueOf(serverInformation.isTlsEnabled()));
        props.put("mail.smtp.host", serverInformation.getHostname());
        props.put("mail.smtp.port", String.valueOf(serverInformation.getPort()));
        //create the Session object
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user.getUsername(), user.getPassword());
            }
        };
        this.session = Session.getInstance(props, authenticator);
    }

    public void sendMessage(String from, String to) {
        if (session == null) {
            throw new IllegalStateException("SMTP session is not created yet.");
        }
        try {
            //create a MimeMessage object
            Message message = new MimeMessage(session);
            //set From email field
            message.setFrom(new InternetAddress(from));
            //set To email field
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            //set email subject field
            message.setSubject("Here comes Jakarta Mail!");
            //set the content of the email message
            message.setText("Just discovered that Jakarta Mail is fun and easy to use");
            //send the email message
            Transport.send(message);
            System.out.println("Email Message Sent Successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

