package com.neilgrogan.pluralsight_jee.intro.jpa;


public class Main {

  public static void main(String[] args) {

    BookService bookService = new BookService();
    
    // Persist a book
    Book b = new Book(1L, "H2G2", "Best Scifi Book", 12.5f, "1234-5678-91011");
    bookService.persistBook(b);
    
    // Find the Book
    Book rb = bookService.findBook(1l);
    
    // Print the result
    System.out.println(rb);

  }

} 