package com.example.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.mail.MessagingException;
import java.util.*;

import com.example.model.update_pass;
import com.example.util.mailutil;

public class sendpass extends HttpServlet{
  public void doPost (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

    String emailaddress = request.getParameter("email");
    String from ="sabgamehai@gmail.com";
    String body="Your new password is :"+update_pass.update(emailaddress)+"\n thank you ";
    try{
      mailutil.sendmail(emailaddress,from,body);
    }catch(MessagingException e){
      e.printStackTrace();
    }
  }
}
