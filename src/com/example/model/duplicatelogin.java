package com.example.model;
import java.io.*;
import java.sql.*;

public class duplicatelogin {
  public static boolean duplicate(String email,String pass){
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    boolean status=false;
    DBConnection dbc = new DBConnection();

    try{
      con=dbc.getConnection();
      ps=con.prepareStatement("select * from user where email=?");
      ps.setString(1,email);
      rs=ps.executeQuery();
      status=rs.next();
      }catch(Exception e){
        System.out.println(e);
      }finally{
        if(con!=null){
          try{
            con.close();
          }catch(Exception e2){
            e2.printStackTrace();
          }
        }
        if(ps!=null){
          try{
            ps.close();
          }catch(Exception e2){
            e2.printStackTrace();
          }
        }
        if(rs!=null){
          try{
            rs.close();
          }catch(Exception e2){
            e2.printStackTrace();
          }
        }
      }
    return status;
  }
}
