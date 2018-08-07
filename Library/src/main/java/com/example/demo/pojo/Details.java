package com.example.demo.pojo;

import java.util.List;

public class Details {
	
private List<Members> member;
private List<Books> book;

public Details() {
	
}

public List<Members> getMember() {
	return member;
}

public void setMember(List<Members> member) {
	this.member = member;
}

public List<Books> getBook() {
	return book;
}

public void setBook(List<Books> book) {
	this.book = book;
}


}
