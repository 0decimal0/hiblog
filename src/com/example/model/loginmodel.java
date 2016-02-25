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
    boolean status=false;

    try{
        con=DBConnection.getConnection();

        ps=con.prepareStatement("INSERT INTO user VALUES(?,?,sha1(?))");
        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,password);

        ps.executeUpdate();
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
