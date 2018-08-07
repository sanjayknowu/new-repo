package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.pojo.BarrowedBookList;
import com.example.demo.pojo.Books;
import com.example.demo.pojo.Librarian;
import com.example.demo.pojo.Members;
import com.example.demo.service.RootService;

@Controller
public class RootController {
	
	@Autowired(required=true)
	private RootService rootService;
	
	@RequestMapping(value = "/")
	public ModelAndView main() {
		getRootService().createlogInTable();
		getRootService().createBorrowedTable();
		getRootService().createBooksTable();
		getRootService().createMembersTable();
		return new ModelAndView("home");
	}
	
	/*@RequestMapping(value="/main")
	public ModelAndView logIn(){
		return new ModelAndView("main");
	}*/
	
	@RequestMapping(value="/issue")
	public ModelAndView issue(){
		return new ModelAndView("issuing");
	}
	
	@RequestMapping(value="/checkmember")
	public ModelAndView checkmember(){
		return new ModelAndView("checkMembers");
	}
	
	@RequestMapping(value="/memberCheck",method=RequestMethod.POST)
	public ModelAndView checkmembers(@RequestParam int mId){
		System.out.println("memeber id "+mId);
		ModelAndView view = new ModelAndView("checkMembers");
		if(getRootService().checkmembers(mId))
			{
			view = new ModelAndView("availableBooks");
			}
		return view ;
	}
	
	@RequestMapping(value="/lent")
	public ModelAndView lent(){
		return new ModelAndView("admin");
	}
	
	@RequestMapping(value="/book")
	public ModelAndView book(){
		return new ModelAndView("addBooks");
	}
	
	@RequestMapping(value="/checkBooks")
	public ModelAndView checkBooks(){
		return new ModelAndView("availableBooks");
	}
	
	@RequestMapping(value="/addBooks")
	public ModelAndView addBooks(@ModelAttribute Books obj){
		System.out.println("book date "+obj.getDate());
		getRootService().addBooks(obj);
		return new ModelAndView("addBooks");
	}
	
	@RequestMapping(value="/booksCheck")
	public ModelAndView booksCheck(@RequestParam int bId){
		System.out.println("book id "+bId);
		ModelAndView view = new ModelAndView("availableBooks");
		if(getRootService().booksCheck(bId))
			{
			view = new ModelAndView("issuing");
			}
		return view ;
	}
	
	/*@RequestMapping(value="/details")
	public ModelAndView details(){
		ModelAndView view =	new ModelAndView("details");
		view.addObject("listOfMembers", getRootService().details());
		
			return view;
	}*/
	
	@RequestMapping(value="/memberList")
	public ModelAndView memberList(){
		ModelAndView view =	new ModelAndView("memberDetail");
		view.addObject("listOfMembers", getRootService().memberList());
			return view;
	}
	
	@RequestMapping(value="/bookList")
	public ModelAndView availableBooks(){
		ModelAndView view =	new ModelAndView("bookDetails");
		view.addObject("listOfBooks", getRootService().availableBooks());
			return view;
	}
	
	@RequestMapping(value="/checkBook/{bId}/{bName}")
	public void checkBook(@PathVariable int bId, @PathVariable String bName){
		System.out.println("book id "+bId);
		System.out.println("book name "+bName);
	}
	
	@RequestMapping(value="/members")
	public ModelAndView members(){
		return new ModelAndView("addMembers");
	}
	
	@RequestMapping(value="/addMembers",method=RequestMethod.POST)
	public ModelAndView addMembers(@ModelAttribute Members obj){
		System.out.println("member id "+obj.getDate());
		getRootService().addMembers(obj);
		return new ModelAndView("addMembers");
	}
	
	@RequestMapping(value="/login")
	public ModelAndView logIn(@ModelAttribute Librarian obj){
		ModelAndView view = new ModelAndView("checkMembers");
//			if(getRootService().logIn(obj))
//				{
//				view = new ModelAndView("checkMembers");
//				}
			return view ;
	}
	

	@RequestMapping(value="/borrowed")
	public ModelAndView borrowed(){
		return new ModelAndView("borrowed");
	}
	
	@RequestMapping(value="/submit")
	public ModelAndView submit(){
		return new ModelAndView("admin");
	}
	
	@RequestMapping(value="/assignbook",method=RequestMethod.POST)
	public ModelAndView submitBook(@RequestParam int mbrId, String mbrName, int bookId, String bookName, String issuedDate, String endDate){
		System.out.println(endDate);
		getRootService().submitBook(mbrId, mbrName, bookId, bookName, issuedDate, endDate);
		ModelAndView view= new ModelAndView("issuing");
		view.addObject("result", "sucessfully Assigned");
		return view;
				
	}
	
	@RequestMapping(value="/borrowedList",method=RequestMethod.POST)
	public @ResponseBody ModelAndView borrowedList(@RequestParam int employeeId)
	{
		System.out.println(employeeId);
		ModelAndView view =	new ModelAndView("borrowed");
		view.addObject("listofbarrow", getRootService().borrowedList(employeeId));
		return view;
	
		
	}
	
	@RequestMapping(value="/returnedList",method=RequestMethod.POST)
	public @ResponseBody List<BarrowedBookList> returnedList(@RequestParam int empValue)
	{
		System.out.println(empValue);
	return getRootService().returnedList(empValue);
		
	}
	
	@RequestMapping(value="/return/{id}/{mbrId}/{bookId}")
	public ModelAndView delete(@PathVariable int id, @PathVariable int mbrId, @PathVariable int bookId){
		System.out.println("table id "+id);
		System.out.println("member id "+mbrId);
		System.out.println("book id "+bookId);
		ModelAndView view =	new ModelAndView("borrowed");
		view.addObject("listofbarrow", getRootService().delete(id, mbrId, bookId));
		return view;
		
	}
	
	/*@RequestMapping(value="/renew/{id}/{mbrId}",method=RequestMethod.POST)
	public @ResponseBody ModelAndView returned(@RequestParam String duedate, @PathVariable int id, @PathVariable int mbrId){
		System.out.println("due date "+duedate);
		System.out.println("table id "+id);
		System.out.println("table id "+mbrId);
		ModelAndView view =	new ModelAndView("borrowed");
		view.addObject("listofbarrow", getRootService().update(duedate, id, mbrId));
		return view;
		
	}*/
	
	@RequestMapping(value="/renewed/{id}",method=RequestMethod.POST)
	public @ResponseBody List<BarrowedBookList> update(@RequestParam(value="memId") int memId, @RequestParam(value="duedate") String duedate, @PathVariable(value="id") int id){
		System.out.println("table id "+id);
		System.out.println("member id "+memId);
		System.out.println("due date "+duedate);
		
		return getRootService().update(duedate, id, memId);
		 
	}
	
	
	public RootService getRootService() {
		return rootService;
	}
	public void setRootService(RootService rootService) {
		this.rootService = rootService;
	}
	
}
