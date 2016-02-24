package com.example.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection{
  public static Connection getConnection(){
    Properties props = new Properties();
    FileInputStream fis = null;
    Connection con=null;
    try{
      fis =new FileInputStream("db.properties");
      props.load(fis);
      con = DriverManager.getConnection(props.getProperty("db_url"),props.getProperty("db_user"),props.getProperty("db_password"));
    }catch(IOException | SQLException e){
      e.printStackTrace();
    }
    return con;
  }
}
