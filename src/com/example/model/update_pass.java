package com.example.model;
import java.io.*;
import java.sql.*;

import com.example.util.generatepass;

public class update_pass {
  public static String update(String email){
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    //boolean status=false;
    String repass=generatepass.randomstring(8);

    try{
      con=DBConnection.getConnection();
      ps=con.prepareStatement("update user set password=sha1(?) where email=?");
      ps.setString(1,repass);
      ps.setString(2,email);
      ps.executeUpdate();
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
    return repass;
  }
}
