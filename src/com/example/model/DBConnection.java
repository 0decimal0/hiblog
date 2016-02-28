package com.example.model;

import java.io.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection{
  public static Connection getConnection(){
    Properties props = new Properties();
    InputStream input_stream = null;
    Connection con=null;
    try{
      ClassLoader classloader=Thread.currentThread().getContextClassLoader();
      input_stream =classloader.getResourceAsStream("db.properties");
      props.load(input_stream);
      con = DriverManager.getConnection(props.getProperty("db_url"),props.getProperty("db_user"),props.getProperty("db_password"));
    }catch(IOException | SQLException e){
      e.printStackTrace();
    }
    return con;
  }
}
