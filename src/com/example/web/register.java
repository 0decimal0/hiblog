package com.example.web;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.*;

import com.example.model.loginmodel;

public class register extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String e=request.getParameter("email");
    String pass= request.getParameter("newPassword");

    /*HttpSession session = request.getSession(false);
    if(session!=null)
      session.setAttribute("email",e);*/
    if (loginmodel.validate(e,pass)){
      RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
      rd.forward(request,response);
    }
    else{
      out.print("OOps");
      RequestDispatcher rd=request.getRequestDispatcher("login.html");
      rd.include(request,response);
    }
    out.close();
  }
}
