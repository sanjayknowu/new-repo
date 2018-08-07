package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TableCreation;
import com.example.demo.daoImpl.RootDao;
import com.example.demo.pojo.BarrowedBookList;
import com.example.demo.pojo.Books;
import com.example.demo.pojo.Details;
import com.example.demo.pojo.Librarian;
import com.example.demo.pojo.Members;


@Service
public class RootService {

	@Autowired(required=true)
	private RootDao rootDao;

	@Autowired(required=true)
	private TableCreation tableCreation;
	
	@Transactional
	public boolean createlogInTable()
	{
		return getTableCreation().createLogInTable();
	}
	
	@Transactional
	public boolean createBorrowedTable()
	{
		return getTableCreation().createBorrowedTable();
	}
	
	@Transactional
	public boolean createBooksTable()
	{
		return getTableCreation().createBooksTable();
	}
	
	@Transactional
	public boolean createMembersTable()
	{
		return getTableCreation().createMembersTable();
	}
	
	@Transactional
	public boolean submitBook(int empId, String empName, int bookId, String bookName, String issuedDate, String endDate) {
		return getRootDao().submitBook(empId, empName, bookId, bookName, issuedDate, endDate);
		
	}
	
	@Transactional
	public List<BarrowedBookList> borrowedList(int employeeId)
	{
	return	getRootDao().borrowedList(employeeId);
	}
	
	@Transactional
	public List<BarrowedBookList> returnedList(int empValue)
	{
	return	getRootDao().returnedList(empValue);
	}
	
	@Transactional
	public boolean checkmembers(int mId)
	{
		return getRootDao().checkmembers(mId);
	}
	
	@Transactional
	public boolean booksCheck(int bId)
	{
		return getRootDao().booksCheck(bId);
	}
	
	@Transactional
	public boolean logIn(Librarian obj)
	{
		return getRootDao().logIn(obj);
	}
	
	@Transactional
	public List<BarrowedBookList> returned(int id, int bookId)
	{
		return getRootDao().returned(id, bookId);
	}
	
	@Transactional
	public List<BarrowedBookList> update(String dueDate, int id, int mbrId)

	{
		System.out.println("service updated date "+dueDate);
		return getRootDao().update(dueDate, id, mbrId);
	}
	
	@Transactional
	public List<BarrowedBookList> delete(int id, int mbrId, int bookId)
	{
		return getRootDao().delete(id, mbrId, bookId);
	}
	
	@Transactional
	public boolean addBooks(Books obj)
	{
		return getRootDao().addBooks(obj);
	}
	
	@Transactional
	public List<Members> memberList()
	{
		return getRootDao().memberList();
	}
	
	@Transactional
	public List<Books> availableBooks()
	{
		return getRootDao().availableBooks();
	}
	
	@Transactional
	public List<Details> details()
	{
		return getRootDao().details();
	}
	
	@Transactional
	public boolean addMembers(Members obj)
	{
		return getRootDao().addMembers(obj);
	}
	
	public RootDao getRootDao() {
		return rootDao;
	}

	public void setRootDao(RootDao rootDao) {
		this.rootDao = rootDao;
	}

	public TableCreation getTableCreation() {
		return tableCreation;
	}

	public void setTableCreation(TableCreation tableCreation) {
		this.tableCreation = tableCreation;
	}

	
}
