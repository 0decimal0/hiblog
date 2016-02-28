package com.example.web;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.*;

import com.example.model.loginverify;

public class login extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String e = request.getParameter("email");
    String p = request.getParameter("password");
    if(loginverify.loginmatch(e,p)){
      RequestDispatcher rd = request.getRequestDispatcher("profile.html");
      rd.forward(request,response);
    }
    else{
      out.print("Sorry wrong email or password");
    }
    out.close();
  }
}
