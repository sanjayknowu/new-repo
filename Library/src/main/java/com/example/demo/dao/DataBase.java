package com.example.demo.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DataBase {
	
	private static Connection con = null;
	private static DataBase instance;
	private DataBase(){
		try {

	        Class.forName("com.mysql.jdbc.Driver");
	        //connect DB
	        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");

	    }

	    catch(SQLException e)
	    {
	        System.err.println(e.getMessage());

	    }

	    catch(ClassNotFoundException e)
	    {

	        System.err.println(e.getMessage());

	    }   
	}
	  public static Connection getInstance()
	  {
		  if(instance==null){
			  instance = new DataBase();
		  }
	          
	      return con;

	  }
}

