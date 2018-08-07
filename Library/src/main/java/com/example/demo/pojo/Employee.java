package com.example.demo.pojo;

public class Employee {
private int eId;
private String eName;
private String eMail;
private String ePass;
private long ssn;
private long phNumber;

public String geteMail() {
	return eMail;
}

public void seteMail(String eMail) {
	this.eMail = eMail;
}

public String getePass() {
	return ePass;
}

public void setePass(String ePass) {
	this.ePass = ePass;
}

public long getPhNumber() {
	return phNumber;
}

public void setPhNumber(long phNumber) {
	this.phNumber = phNumber;
}

public Employee() {
	
}

public int geteId() {
	return eId;
}

public void seteId(int eId) {
	this.eId = eId;
}

public String geteName() {
	return eName;
}

public void seteName(String eName) {
	this.eName = eName;
}

public long getSsn() {
	return ssn;
}

public void setSsn(long ssn) {
	this.ssn = ssn;
}

}
