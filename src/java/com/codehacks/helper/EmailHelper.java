package com.codehacks.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author E238958
 */
public class EmailHelper {

    public static boolean sendEmail(String emailAddress) {
        String to = "rubytech7@gmail.com";
        String from = "electengrhume@gmail.com";
        String host = "localhost";

        // Get the session object
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        // Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Confirm Registration on Cargo App");
            String text = "Thanks for registering with us. Kindly click the link sent to your mail to confirm registration";
            message.setText(text);

            // Send message
            Transport.send(message);
            System.out.println("Message sent successfully...");
        } catch (MessagingException mex) {
        }

        return true;
    }

    public static void sendEmail2(String emailAdd) {
        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "true");
            prop.put("mail.smtp.auth", true);
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            //prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

            String username = "electengrhume@gmail.com";
            String password = "raconteur7";
            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("electengrhume@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse("rubytech7@gmail.com"));
            message.setSubject("Confirm Registration on Cargo App");

            String msg = "Thanks for registering with us. "
                    + "Kindly click the link sent to your mail to confirm registration";

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendEmail3(String address1) {
        //Setting up configurations for the email connection to the Google SMTP server using TLS

        Properties props = new Properties();

        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        //Establishing a session with required user details
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("electengrhume@gmail.com", "raconteur7");
            }
        });

        try {
            //Creating a Message object to set the email content
            MimeMessage msg = new MimeMessage(session);

            //Storing the comma seperated values to email addresses
            String to = "recepient1@email.com,recepient2@gmail.com";

            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
                addresses in an array of InternetAddress objects*/
            InternetAddress[] address = InternetAddress.parse(to, true);

            //Setting the recepients from the address variable
            msg.setRecipients(Message.RecipientType.TO, address);

            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());

            msg.setSubject("Sample Mail : " + timeStamp);
            msg.setSentDate(new Date());
            msg.setText("Sample System Generated mail");
            msg.setHeader("XPriority", "1");

            Transport.send(msg);
        } catch (MessagingException mex) {
            System.out.println("Unable to send an email" + mex);
        }
    }
}