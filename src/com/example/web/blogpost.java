package com.example.web;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.*;

import com.example.model.update_post;

public class blogpost extends HttpServlet{
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    String b = request.getParameter("txtarea");
    HttpSession session = request.getSession();
    String e = (String)session.getAttribute("email");
    //Cookie[] cookies = request.getCookies();
    //String e = cookies[0].getValue();
    StringBuffer buffer = update_post.update(e,b);
    //String blog = (String)buffer;
    session.setAttribute("blog",b);
    //session.setAttribute("up_status",update_status)
    response.sendRedirect("home.jsp");
    //out.print(blog);

      //RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
      //rd.forward(request,response);
     
    out.close();
  }
}
