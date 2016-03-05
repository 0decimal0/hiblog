package com.example.web;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.http.HttpSession;

import com.example.model.loginverify;

public class login extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String e = request.getParameter("email");
    String p = request.getParameter("password");

    HttpSession session = request.getSession();
    session.setAttribute("email",e);
    //Cookie ck = new Cookie("email",e);
    //response.addCookie(ck);

    if(loginverify.loginmatch(e,p)){
      RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
      rd.forward(request,response);
    }
    else{
      out.print("Sorry wrong email or password");
    }
    out.close();
  }
}
