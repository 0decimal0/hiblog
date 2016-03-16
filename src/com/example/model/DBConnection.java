package com.example.model;

import java.io.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;
import javax.sql.*;
import javax.naming.*;
import org.apache.commons.dbcp2.BasicDataSource;

public final class DBConnection{
  public static BasicDataSource datasource=new BasicDataSource();
    Properties props = new Properties();
    InputStream input_stream = null;
    public DBConnection(){
    //Connection con=null;
    try{
      ClassLoader classloader=Thread.currentThread().getContextClassLoader();
      input_stream =classloader.getResourceAsStream("db.properties");
      props.load(input_stream);
      //Context ctx = new InitialContext();
      //ctx.bind("jdbc/hiblog",datasource);
    }catch(IOException e){
      e.printStackTrace();
    }
      datasource.setUrl(props.getProperty("db_url"));
      datasource.setUsername(props.getProperty("db_user"));
      datasource.setPassword(props.getProperty("db_password"));
    }
  public static Connection getConnection(){
    Connection con=null;
    try{
      //con = DriverManager.getConnection(props.getProperty("db_url"),props.getProperty("db_user"),props.getProperty("db_password"));
      con = datasource.getConnection();
    }catch(SQLException e2){
      e2.printStackTrace();
    }
    //public static Connection getConnection throws SQLException{
      //return datasource.getConnection();
   return con;
    }
}
