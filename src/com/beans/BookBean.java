package com.beans;

public class BookBean {

	private String bookid;
	private String Name;
	private String Author;
	private String Publisher;
	private String Image;
	private int Issued;	
	
	
	public BookBean() {
		super();
	}

	public BookBean(String bookid, String name, String author, String publisher,
			int issued, String image) {
		super();
		this.bookid = bookid;
		Name = name;
		Author = author;
		Publisher = publisher;
		Image = image;
		Issued = issued;
		
	}

	public String getBookid() {
		return bookid;
	}
	public String getImage() {
		return Image;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getName() {
		return Name;
	}
	public String getAuthor() {
		return Author;
	}
	public String getPublisher() {
		return Publisher;
	}
	public int getIssued() {
		return Issued;
	}
	
	public void setName(String name) {
		Name = name;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public void setIssued(int issued) {
		Issued = issued;
	}


}
