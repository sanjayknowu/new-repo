package com.example.demo.dao;

import java.sql.ResultSet;

import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.DataBase;
import com.mysql.jdbc.Connection;

@Repository
public class TableCreation {

	public boolean createLogInTable() {
		boolean result = false;
		   Connection con = DataBase.getInstance();
	       Statement ps;
	       ResultSet rs;
	       try {
	    	   rs = con.getMetaData().getTables(null, null, "logIn", null);
	    	   if (rs.next()) { 
	    		   result = false;
	    	   }
	    	   else{
	            	   String sql = "CREATE TABLE logIn " +
	    	                   "(lId INTEGER NOT NULL AUTO_INCREMENT UNIQUE, " +
	    	                   " lName VARCHAR(255), " + 
	    	                   " lMail VARCHAR(255), " + 
	    	                   " lPass VARCHAR(255), " + 
	    	                   " phNumber bigint, " + 
	    	                   " primary key ( lId ))"; 
	    	    	   
	    	    	   ps = con.createStatement();
	    	    	   result = ps.execute(sql);
				}
	    	   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public boolean createBooksTable() {
		boolean result = false;
		   Connection con = DataBase.getInstance();
	       Statement ps;
	       ResultSet rs;
	       try {
	    	   rs = con.getMetaData().getTables(null, null, "books", null);
	    	   if (rs.next()) { 
	    		   result = false;
	    	   }
	    	   else{
	            	   String sql = "CREATE TABLE books " +
	    	                   "(bId INTEGER NOT NULL AUTO_INCREMENT UNIQUE, " +
	    	                   " bName VARCHAR(255), " + 
	    	                   " bAuthor VARCHAR(255), " + 
	    	                   " date VARCHAR(255), " + 
	    	                   " status VARCHAR(255), " +
	    	                   " primary key ( bId ))"; 
	    	    	   
	    	    	   ps = con.createStatement();
	    	    	   result = ps.execute(sql);
				}
	    	   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public boolean createBorrowedTable() {
		boolean result = false;
		   Connection con = DataBase.getInstance();
	       Statement ps;
	       ResultSet rs;
	       try {
	    	   rs = con.getMetaData().getTables(null, null, "borrowedList", null);
	    	   if (rs.next()) { 
	    		   result = false;
	    	   }
	    	   else{
	            	   String sql = "CREATE TABLE borrowedList " +
	    	                   "(id INTEGER NOT NULL AUTO_INCREMENT UNIQUE, " +
	    	                   " mbrId INTEGER, " + 
	    	                   " mbrName VARCHAR(255), " + 
	    	                   " bookId INTEGER, " + 
	    	                   " bookName VARCHAR(255), " +
	    	                   " issuedDate VARCHAR(255), " +
	    	                   " dueDate VARCHAR(255), " +
	    	                   " status INTEGER, " +
	    	                   " primary key ( id ))"; 
	    	    	   
	    	    	   ps = con.createStatement();
	    	    	   result = ps.execute(sql);
				}
	    	   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public boolean createMembersTable() {
		boolean result = false;
		   Connection con = DataBase.getInstance();
	       Statement ps;
	       ResultSet rs;
	       try {
	    	   rs = con.getMetaData().getTables(null, null, "members", null);
	    	   if (rs.next()) { 
	    		   result = false;
	    	   }
	    	   else{
	            	   String sql = "CREATE TABLE members " +
	    	                   "(mId INTEGER NOT NULL AUTO_INCREMENT UNIQUE, " +
	    	                   " mName VARCHAR(255), " + 
	    	                   " phNo bigint, " + 
	    	                   " date VARCHAR(255), " + 
	    	                   " primary key ( mId ))"; 
	    	    	   
	    	    	   ps = con.createStatement();
	    	    	   result = ps.execute(sql);
				}
	    	   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
