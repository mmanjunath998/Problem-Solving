package com.basics.design;

import java.util.Date;
import java.util.List;
import java.util.Map;

enum BookStatus{
	AVAILABLE,
	RESERVED,
	LOANED,
	LOST;
}

enum BookFormat{
	HARDCOVER,
	AUDIOBOOK,
	EBOOK,
	NEWSPAPER,
	MAGAZINE,
	JOURNAL;
}

class Author{
	private String name;
	private String authorId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	
}
class Book{
	private String ISBN;
	private String title;
	private String subject;
	private String publisher;
	private String language;
	private int numberOfPages;
	private List<Author> authors;
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
}

class BookItem extends Book{
	private String barcode;
	private Date borrowed;
	private Date dueDate;
	private Date dataOfPublication;
	private Date dateOfPurchase;
	private BookStatus bookStatus;
	private double price;
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public Date getBorrowed() {
		return borrowed;
	}
	public void setBorrowed(Date borrowed) {
		this.borrowed = borrowed;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getDataOfPublication() {
		return dataOfPublication;
	}
	public void setDataOfPublication(Date dataOfPublication) {
		this.dataOfPublication = dataOfPublication;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public BookStatus getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(BookStatus bookStatus) {
		this.bookStatus = bookStatus;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}

 interface SearchR{
	
	 List<Book> searchByTitle(String title);
	 List<Book> searchByAuthor(String author);
	 List<Book> searchByPubDate(Date pubDate);
	 List<Book> searchBySubject(String subject);
	 
}
 class Catalog implements SearchR{
	 
	 Map<String,List<Book>> booksByTitles;
	 Map<String, List<Book>> booksByAuthor;
	 Map<String, List<Book>> booksBySubject;
	 Map<String, List<Book>> booksByPubDate;
	 
	 
	 

	@Override
	public List<Book> searchByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchBySubject(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchByPubDate(Date pubDate) {
		// TODO Auto-generated method stub
		return null;
	}
	 
 }
public class Library {

}
