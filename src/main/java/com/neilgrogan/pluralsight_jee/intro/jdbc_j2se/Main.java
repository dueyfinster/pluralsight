package com.neilgrogan.pluralsight_jee.intro.jdbc_j2se;

import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) {

		try {
			// Persist a book
			Database db = new Database();
			db.persistBook(new Book(1L, "H2G2", "Best Scifi Book",12.5f, "1234-5678-91011"));
			// Find the Book
			Book book = db.findBook(1L);
			// Print the result
			System.out.println(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
