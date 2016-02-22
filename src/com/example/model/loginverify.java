package com.example.model;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.*;

public class loginverify {
  public static boolean loginmatch(String email,String pass){
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    boolean verified=false;

    try{
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiblog","root","rohit123");
      
      ps = con.prepareStatement("select * from user where email=? and password=sha1(?)");
      ps.setString(1,email);
      ps.setString(2,pass);
      rs = ps.executeQuery();
      //String e=rs.getString("email");
      //String p=rs.getString("password");
      //if(email.equals(e) && pass.equals(p))
        //verified=true;
      verified=rs.next();
    }catch (Exception e){
      System.out.println(e);
    }finally{
      if(con!=null){
        try{
          con.close();
        }catch(Exception e){
          e.printStackTrace();
        }
      }
      if(ps!=null){
        try{
          ps.close();
        }catch(Exception e){
          e.printStackTrace();
        }
      }
      if(rs!=null){
        try{
          rs.close();
        }catch(Exception e){
          e.printStackTrace();
        }
      }
    }
    return verified;
  }
}
