package com.example.demo.pojo;


public class BarrowedBookList {
private int id;
private int mbrId;
private String mbrName;
private int bookId;
private String bookName;
private String issuedDate;
private String dueDate;
private int status;


public BarrowedBookList() {
	
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public int getMbrId() {
	return mbrId;
}


public void setMbrId(int mbrId) {
	this.mbrId = mbrId;
}


public String getMbrName() {
	return mbrName;
}


public void setMbrName(String mbrName) {
	this.mbrName = mbrName;
}


public int getBookId() {
	return bookId;
}


public void setBookId(int bookId) {
	this.bookId = bookId;
}


public String getBookName() {
	return bookName;
}


public void setBookName(String bookName) {
	this.bookName = bookName;
}


public String getIssuedDate() {
	return issuedDate;
}


public void setIssuedDate(String issuedDate) {
	this.issuedDate = issuedDate;
}


public String getDueDate() {
	return dueDate;
}


public void setDueDate(String dueDate) {
	this.dueDate = dueDate;
}


public int getStatus() {
	return status;
}


public void setStatus(int status) {
	this.status = status;
}

}
