package com.example.demo.daoImpl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.DataBase;
import com.mysql.jdbc.Connection;
import com.example.demo.pojo.*;

@Repository
public class RootDao {
	
	public boolean checkmembers(int mId) {
		boolean result = false;
		   Connection con = DataBase.getInstance();
	       Statement ps;
	       ResultSet rs;
		try {
			ps = con.createStatement();
			String str = "SELECT * FROM members where mId = "+mId;
			System.out.println(str);
			rs = ps.executeQuery(str);
			if (rs.next()) {
				result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	public boolean booksCheck(int bId) {
		boolean result = false;
		   Connection con = DataBase.getInstance();
	       Statement ps;
	       ResultSet rs;
		try {
			ps = con.createStatement();
			String str = "SELECT * FROM books where bId = "+bId+" and status = "+0;
			System.out.println(str);
			rs = ps.executeQuery(str);
			if (rs.next()) {
				result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	public boolean addBooks(Books obj) {
		boolean res = false;
		   Connection con = DataBase.getInstance();
	       Statement ps;
		try {
			ps = con.createStatement();
			String str = "INSERT INTO books VALUES ("+0+", '"+obj.getbName()+"', '"+obj.getbAuthor()+"', '"+obj.getDate()+"', "+0+")";
			System.out.println(str);
			res= ps.execute(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public boolean submitBook(int empId, String empName, int bookId, String bookName, String issuedDate, String endDate) {
		boolean res = false;
		   Connection con = DataBase.getInstance();
	       Statement ps;
		try {
			ps = con.createStatement();
			String str = "INSERT INTO borrowedList VALUES ("+0+","+empId+", '"+empName+"', "+bookId+", '"+bookName+"', '"+issuedDate+"','"+endDate+"', "+1+")";
			System.out.println(str);
			res= ps.execute(str);
			String str1 = "UPDATE books SET status = "+1+" where bId = "+bookId;
			System.out.println(str1);
			res= ps.execute(str1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean addMembers(Members obj) {
		boolean res = false;
		   Connection con = DataBase.getInstance();
	       Statement ps;
		try {
			ps = con.createStatement();
			String str = "INSERT INTO members VALUES ("+0+", '"+obj.getmName()+"', "+obj.getPhNo()+", '"+obj.getDate()+"')";
			System.out.println(str);
			res= ps.execute(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public List<BarrowedBookList> borrowedList(int employeeId){
		ArrayList<BarrowedBookList> list = new ArrayList<BarrowedBookList>();
		boolean res = false;
		 Connection con = DataBase.getInstance();
	     Statement ps;
	     ResultSet rs;
	     try {
	    	 ps = con.createStatement();
	    	 String str = "SELECT * FROM borrowedList where status = "+1+" and mbrId = "+employeeId;
	    	 System.out.println(str);
	    	 rs = ps.executeQuery(str);
	    	 while(rs.next()){
	    		 BarrowedBookList blist=new  BarrowedBookList();
	    		 blist.setId(rs.getInt("Id"));
	    		 blist.setMbrId(rs.getInt("mbrId"));
	    		 System.out.println(rs.getInt("mbrId"));
	    		 blist.setMbrName(rs.getString("mbrName"));
	    		 blist.setBookId(rs.getInt("bookId"));
	    		 blist.setBookName(rs.getString("bookName"));
	    		 blist.setIssuedDate(rs.getString("issuedDate"));    		 
	    		 blist.setDueDate(rs.getString("dueDate"));
	    		 System.out.println(blist.getDueDate());
	    		 blist.setStatus(rs.getInt("status"));
	    		 list.add(blist); 
	    	 }
	     }  catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}
	
	public List<BarrowedBookList> returnedList(int empValue){
		ArrayList<BarrowedBookList> list = new ArrayList<BarrowedBookList>();
		boolean res = false;
		 Connection con = DataBase.getInstance();
	     Statement ps;
	     ResultSet rs;
	     try {
	    	 ps = con.createStatement();
	    	 String str = "SELECT * FROM borrowedList where status = "+0+" and empId = "+empValue;
	    	 System.out.println(str);
	    	 rs = ps.executeQuery(str);
	    	 while(rs.next()){
	    		 BarrowedBookList blist=new  BarrowedBookList();
	    		 blist.setId(rs.getInt("Id"));
	    		 blist.setMbrId(rs.getInt("empId"));
	    		 System.out.println(rs.getInt("empId"));
	    		 blist.setMbrName(rs.getString("empName"));
	    		 blist.setBookId(rs.getInt("bookId"));
	    		 blist.setBookName(rs.getString("bookName"));
	    		 blist.setIssuedDate(rs.getString("issuedDate"));    		 
	    		 blist.setDueDate(rs.getString("dueDate"));
	    		 System.out.println(blist.getDueDate());
	    		 blist.setStatus(rs.getInt("status"));
	    		 list.add(blist); 
	    	 }
	     }  catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}
	
	public boolean logIn(Librarian obj)
	{
		boolean result = false;
		 Connection con = DataBase.getInstance();
	     Statement ps;
	     ResultSet rs;
	     try {
	    	 ps = con.createStatement();
	    	 String str = "SELECT * FROM login where lMail = '"+obj.getlMail()+"' and lPass = '"+obj.getlPass()+"'";
	    	 System.out.println(str);
	    	 rs = ps.executeQuery(str);
	    	
	    	 if(rs.next())
	    		 {
	    		 result = true;
	    		 }
	     }
	     catch (Exception e) {
				e.printStackTrace();
			}
	     System.out.println(result);
		return result;
	}
	
	public boolean checkDetails(int empId, int bookId)
	{
		boolean result = true;
		 Connection con = DataBase.getInstance();
	     Statement ps;
	     ResultSet rs;
	     try {
	    	 ps = con.createStatement();
	    	 String str = "SELECT * FROM borrowedList where mbrId = "+empId+" and bookId = "+bookId+" and status = "+1;
	    	 System.out.println(str);
	    	 rs = ps.executeQuery(str);
	    	
	    	 if(rs.next())
	    		 {
	    		 result = false;
	    		 }
	     }
	     catch (Exception e) {
				e.printStackTrace();
			}
	     System.out.println(result);
		return result;
	}
	
	public List<BarrowedBookList> returned(int id, int bookId)
	{
		boolean result = false;
		ArrayList<BarrowedBookList> list = new ArrayList<BarrowedBookList>();
		 Connection con = DataBase.getInstance();
	     Statement ps;
	     ResultSet rs;
	     try {
	    	 ps = con.createStatement();
	    	 String str = "UPDATE books SET status = "+0+" where bId = "+bookId;
	    	 System.out.println(str);
	    	 result = ps.execute(str);
	    	 String str1 = "DELETE FROM borrowedList where id = "+id;
	    	 rs = ps.executeQuery(str1);
	    	 while(rs.next()){
	    		 BarrowedBookList blist=new  BarrowedBookList();
	    		 System.out.println(rs.getInt("Id"));
	    		 blist.setId(rs.getInt("Id"));
	    		 blist.setMbrId(rs.getInt("empId"));
	    		 blist.setMbrName(rs.getString("empName"));
	    		 blist.setBookId(rs.getInt("Id"));
	    		 blist.setBookName(rs.getString("bookName"));
	    		 blist.setIssuedDate(rs.getString("issuedDate"));
	    		 blist.setDueDate(rs.getString("dueDate"));
	    		 blist.setStatus(rs.getInt("status"));
	    		 list.add(blist); 
	    	 }
	     }
	     catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}
	
	public List<BarrowedBookList> delete(int id, int mbrId, int bookId)
	{
		boolean result = false;
		ArrayList<BarrowedBookList> list = new ArrayList<BarrowedBookList>();
		 Connection con = DataBase.getInstance();
	     Statement ps;
	     ResultSet rs;
	     try {
	    	 ps = con.createStatement();
	    	 String str = "DELETE FROM borrowedList where id = "+id;
	    	 System.out.println(str);
	    	 result = ps.execute(str);
	    	 String str1 = "UPDATE books SET status = "+0+" where bId = "+bookId;
	    	 System.out.println(str1);
	    	 result = ps.execute(str1);
	    	 String str2 = "SELECT * FROM borrowedList where status = "+1+" and mbrId = "+mbrId;
	    	 System.out.println(str2);
	    	 rs = ps.executeQuery(str2);
	    	 while(rs.next()){
	    		 BarrowedBookList blist=new  BarrowedBookList();
	    		 System.out.println(rs.getInt("Id"));
	    		 blist.setId(rs.getInt("Id"));
	    		 blist.setMbrId(rs.getInt("mbrId"));
	    		 blist.setMbrName(rs.getString("mbrName"));
	    		 blist.setBookId(rs.getInt("bookId"));
	    		 blist.setBookName(rs.getString("bookName"));
	    		 blist.setIssuedDate(rs.getString("issuedDate"));
	    		 blist.setDueDate(rs.getString("dueDate"));
	    		 blist.setStatus(rs.getInt("status"));
	    		 list.add(blist); 
	    	 }
	     }
	     catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}
	
	public List<BarrowedBookList> update(String dueDate, int id, int mbrId){
		System.out.println("dao updated date "+dueDate);
		ArrayList<BarrowedBookList> list = new ArrayList<BarrowedBookList>();
		boolean res = false;
		 Connection con = DataBase.getInstance();
	     Statement ps;
	     ResultSet rs;
	     try {
	    	 
	    	 ps = con.createStatement();
	    	 String str = "UPDATE borrowedList SET dueDate = '"+dueDate+"' where id = "+id;
	    	 System.out.println(str);
	    	 res = ps.execute(str);
	    	 String str1 = "SELECT * FROM borrowedList where status = "+1+" and mbrId = "+mbrId;
	    	 System.out.println(str1);
	    	 rs = ps.executeQuery(str1);
	    	 while(rs.next()){
	    		 BarrowedBookList blist=new  BarrowedBookList();
	    		 blist.setId(rs.getInt("Id"));
	    		 blist.setMbrId(rs.getInt("mbrId"));
	    		 System.out.println(rs.getInt("mbrId"));
	    		 blist.setMbrName(rs.getString("mbrName"));
	    		 blist.setBookId(rs.getInt("bookId"));
	    		 blist.setBookName(rs.getString("bookName"));
	    		 blist.setIssuedDate(rs.getString("issuedDate"));    		 
	    		 blist.setDueDate(rs.getString("dueDate"));
	    		 System.out.println(blist.getDueDate());
	    		 blist.setStatus(rs.getInt("status"));
	    		 list.add(blist); 
	    	 }
	     }  catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}
	
	public ArrayList<Members> memberList(){
		ArrayList<Members> memberList = new ArrayList<Members>();
		 Connection con = DataBase.getInstance();
	     Statement ps;
	     ResultSet rs;
	     try {
	    	 ps = con.createStatement();
	    	 String str = "SELECT * FROM members";
	    	 System.out.println(str);
	    	 rs = ps.executeQuery(str);
	    	 while(rs.next()){
	    		 Members member = new  Members();
	    		 System.out.println(rs.getInt("mId"));
	    		 member.setmId(rs.getInt("mId"));
	    		 member.setmName(rs.getString("mName"));
	    		 member.setPhNo(rs.getLong("phNo"));
	    		 member.setDate(rs.getString("date"));
	    		 memberList.add(member);
	    	 }
	     }  catch (Exception e) {
				e.printStackTrace();
			}
		return memberList;
	}
	
	public ArrayList<Books> availableBooks(){
		ArrayList<Books> list = new ArrayList<Books>();
		 Connection con = DataBase.getInstance();
	     Statement ps;
	     ResultSet rs;
	     try {
	    	 ps = con.createStatement();
	    	 String str = "SELECT * FROM books";
	    	 System.out.println(str);
	    	 rs = ps.executeQuery(str);
	    	 while(rs.next()){
	    		 Books blist=new  Books();
	    		 System.out.println(rs.getInt("bId"));
	    		 blist.setbId(rs.getInt("bId"));
	    		 blist.setbName(rs.getString("bName"));
	    		 blist.setbAuthor(rs.getString("bAuthor"));
	    		 blist.setDate(rs.getString("date"));
	    		 list.add(blist); 
	    	 }
	     }  catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}
	
	public ArrayList<Details> details(){
		ArrayList<Details> detailsList = new ArrayList<Details>();
		Details dlist = new Details();
		ArrayList<Members> memberList = new ArrayList<Members>();
		ArrayList<Books> bookList = new ArrayList<Books>();
		boolean res = false;
		 Connection con = DataBase.getInstance();
	     Statement ps;
	     ResultSet rs;
	     try {
	    	 ps = con.createStatement();
	    	 String str = "SELECT * FROM members";
	    	 System.out.println(str);
	    	 rs = ps.executeQuery(str);
	    	 while(rs.next()){
	    		 Members member = new  Members();
	    		 member.setmId(rs.getInt("mId"));
	    		 member.setmName(rs.getString("mName"));
	    		 member.setPhNo(rs.getInt("phNo"));
	    		 member.setDate(rs.getString("date"));
	    		 memberList.add(member);
	    		 
	     }
	     }catch (Exception e) {
				e.printStackTrace();
			}
	     try {
	    	 ps = con.createStatement();
	    	 String str = "SELECT * FROM books";
	    	 System.out.println(str);
	    	 rs = ps.executeQuery(str);
	    	 while(rs.next()){
	    		 Books book = new  Books();
	    		 book.setbId(rs.getInt("bId"));
	    		 book.setbName(rs.getString("bName"));
	    		 book.setbAuthor(rs.getString("bAuthor"));
	    		 book.setDate(rs.getString("date"));
	    		 bookList.add(book); 
	    	 }
	     }  catch (Exception e) {
				e.printStackTrace();
			}
		return detailsList;
	}  
}
