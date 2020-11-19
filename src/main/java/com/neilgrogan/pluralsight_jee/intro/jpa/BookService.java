package com.neilgrogan.pluralsight_jee.intro.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;

//@Transactional
public class BookService {
	
	@Inject
	private EntityManager em;
	
	public void persistBook(Book b){
		em.persist(b);
	}
	
	public Book findBook(Long id){
		return em.find(Book.class, id);
	}

}
