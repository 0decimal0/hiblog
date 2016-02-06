package com.example.web;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.*;

import com.example.model.loginmodel;
import com.example.model.duplicatelogin;

public class register extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String e=request.getParameter("email");
    String pass= request.getParameter("newPassword");

    if(duplicatelogin.duplicate(e,pass)){
      RequestDispatcher rd=request.getRequestDispatcher("duplicate.html");
      rd.forward(request,response);
    }else{
      if(loginmodel.validate(e,pass)){
        RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
        rd.forward(request,response);
      }else{
        RequestDispatcher rd=request.getRequestDispatcher("register.html");
      rd.include(request,response);
      }
     }
    out.close();
  }
}
