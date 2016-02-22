package com.example.model;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
public class loginmodel{
  public static boolean validate(String name,String email,String password){
    Connection con=null;
    Statement stmt = null;
    PreparedStatement ps = null;
    ResultSet rs=null;
    int count;
    boolean status=false;
    boolean duplicatestatus=false;

    String url = "jdbc:mysql://localhost:3306/hiblog";
    String username="root";
    String pass="rohit123";
    String driver ="com.mysql.jdbc.Driver";

    try{
        con=DriverManager.getConnection(url,username,pass);
        System.out.println("database connected");
        ps=con.prepareStatement("INSERT INTO user VALUES(?,?,sha1(?))");
        System.out.println("statement prepared");
        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,password);
        System.out.println("values inserted");
        ps.executeUpdate();
        System.out.println("statmenet eaxectured");
        ps=con.prepareStatement("select * from user");
        rs=ps.executeQuery();
        status= rs.next();
    }
    catch(Exception e){
      System.out.println(e);
    }
    finally{
      if(con!=null){
        try{
          con.close();
        }catch (Exception e){
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
        }catch (Exception e){
          e.printStackTrace();
        }
      }
    }
   return status;
  }
}
