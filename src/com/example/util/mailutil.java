package com.example.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;

public class mailutil{
  public static void sendmail(String to,String from,String body)throws MessagingException{
    Properties props = new Properties();
    InputStream input_stream=null;
    props.put("mail.smtp.host","smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port","465");
    props.put("mail.smtp.ssl.enable","true");
    props.put("mail.smtp.auth","true");
    props.put("mail.smtp.port","465");

    try{
      ClassLoader classloader = Thread.currentThread().getContextClassLoader();
      input_stream = classloader.getResourceAsStream("db.properties");
      props.load(input_stream);
    }catch(Exception e){
      e.printStackTrace();
    }
    final String username = props.getProperty("smtp_user");
    final String password = props.getProperty("smtp_password");
    //Session session = Session.getInstance(props,null);
    //Transport tr =session.getTransport("smtp");
    //tr.connect("smtp.gmail.com",username,password);
    Session session= Session.getInstance(props,new javax.mail.Authenticator(){
      protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(username,password);
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
    //tr.close();
  }
}
