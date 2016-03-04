package com.example.web;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.*;

import com.example.model.loginverify;

public class blogpost extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
    //session.setAttribute("blog",blog);
    String blog =request.getParameter("id");
    session.setAttribute("blog",blog);
    response.sendRedirect("home.jsp");

      //RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
      //rd.forward(request,response);
    out.close();
  }
}
