package com.example.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class mailutil{
  public static void sendmail(String to,String from,String body)throws MessagingException{
    Properties props = new Properties();
    props.put("mail.smtp.host","smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port","465");
    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth","true");
    props.put("mail.smtp.port","465");


    Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator(){
      protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication("sabgamehai@gmail.com","khushbu123");
      }
    });
    session.setDebug(true);

    Message message = new MimeMessage(session);
    message.setText(body);

    Address fromaddress = new InternetAddress(from);
    Address toaddress = new InternetAddress(to);

    message.setFrom(fromaddress);
    message.setRecipient(Message.RecipientType.TO,toaddress);

    Transport.send(message);
  }
}
