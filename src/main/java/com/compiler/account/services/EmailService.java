package com.compiler.account.services;

import com.compiler.account.constants.EmailConstants;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {

    @Async
    public void sendEmail(String to, String email) throws MessagingException {

        Properties properties = System.getProperties();
        properties.put(EmailConstants.SMTP_HOST, EmailConstants.HOST);
        properties.put(EmailConstants.SMTP_PORT, EmailConstants.PORT);
        properties.put(EmailConstants.SSL_ENABLE, EmailConstants.TRUE);
        properties.put(EmailConstants.SMTP_AUTH, EmailConstants.TRUE);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EmailConstants.EMAIL_USERNAME, EmailConstants.EMAIL_PASSWORD);
            }
        });
        session.setDebug(true);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(EmailConstants.EMAIL_USERNAME);
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setSubject(EmailConstants.SUBJECT);
            mimeMessage.setText(email);
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new MessagingException();
        }

    }
}

