package com.example.model;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.*;

public class update_post {
  public static Blob update(String email,Blob blog){
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    boolean verified=false;
    Blob post=null;

    try{
      con = DBConnection.getConnection();
      ps = con.prepareStatement("insert into post values(?,?)");
      ps.setString(1,email);
      ps.setBlob(2,blog);
      ps.executeUpdate();
      ps = con.prepareStatement("select * from post where email=?");
      ps.setString(1,email);
      //ps.setString(2,pass);
      rs = ps.executeQuery();
      post = rs.getBlob("blog");
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
    return post;
  }
}
