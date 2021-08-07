package com.beans;

import java.sql.Date;

public class IssueBookBean {
private String bookid;
private String studentid;
private String studentname;
private long studentmobile;
private Date issueddate;
private String returnstatus;

public IssueBookBean() {}
public IssueBookBean(String bookid, String studentid, String studentname, long studentmobile) {
	super();
	this.bookid = bookid;
	this.studentid = studentid;
	this.studentname = studentname;
	this.studentmobile = studentmobile;
}

public String getReturnstatus() {
	return returnstatus;
}
public void setReturnstatus(String returnstatus) {
	this.returnstatus = returnstatus;
}
public Date getIssueddate() {
	return issueddate;
}
public void setIssueddate(Date issueddate) {
	this.issueddate = issueddate;
}

public String getBookid() {
	return bookid;
}
public void setBookid(String bookid) {
	this.bookid = bookid;
}

public String getStudentid() {
	return studentid;
}
public void setStudentid(String studentid) {
	this.studentid = studentid;
}
public String getStudentname() {
	return studentname;
}
public void setStudentname(String studentname) {
	this.studentname = studentname;
}
public long getStudentmobile() {
	return studentmobile;
}
public void setStudentmobile(long studentmobile) {
	this.studentmobile = studentmobile;
}

}
