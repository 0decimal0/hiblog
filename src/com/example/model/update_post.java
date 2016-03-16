package com.example.model;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;

public class update_post {
  public static StringBuffer update(String email,String blog){
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    StringBuffer buffer=null;
    boolean verified=false;
    DBConnection dbc =new DBConnection();

    try{
      con = dbc.getConnection();
      ps = con.prepareStatement("insert into post values(?,?)");
      ps.setString(1,email);
      ps.setString(2,blog);
      ps.executeUpdate();
      ps=con.prepareStatement("select * from post where email=?");
      ps.setString(1,email);
      rs= ps.executeQuery();
      String post = rs.getString(2);
      buffer = new StringBuffer(post);
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
    return buffer;
  }
}
