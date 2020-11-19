package com.neilgrogan.pluralsight_jee.intro.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	private Long id;
	private String title;
	private String description;
	private Float unitCost;
	private String isbn;

	public Book(Long id, String title, String description, Float unitCost, String isbn) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.unitCost = unitCost;
		this.isbn = isbn;
	}
	
	public Book(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "[id="+id+",title="+title+",desc="+description+",cost="+unitCost+",isbn="+isbn+"]";
	}
}
