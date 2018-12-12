package com.encore.model;

public class BookDTO {
	private String title;
	private String author;
	private String publisher;
	
	
	public BookDTO() {
		super();
		System.out.println("BookDTO 기본생성자");
	}

	public BookDTO(String title, String author, String publisher) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	public String getTitle() {
		System.out.println("getTitle");
		return title;
	}

	public void setTitle(String title) {
		System.out.println("setTitle");
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookDTO [title=").append(title).append(", author=").append(author).append(", publisher=")
				.append(publisher).append("]");
		return builder.toString();
	}
	
	
}
