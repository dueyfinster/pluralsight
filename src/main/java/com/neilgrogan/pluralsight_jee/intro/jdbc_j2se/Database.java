package com.neilgrogan.pluralsight_jee.intro.jdbc_j2se;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.derby.impl.sql.catalog.SYSROUTINEPERMSRowFactory;

public class Database {
	
	private static Connection connection;
	private String USER_HOME = System.getProperty("user.home");
	private String tableName = "BOOK";
	
	public Database() throws SQLException{
		connection = DriverManager.getConnection("jdbc:derby:"+USER_HOME+"/repos/pluralsight_JEE7_fund/src/main/resources/j2sedb;create=true");
	
		if(tableDoesNotExist(tableName)){
			createTable(tableName);
		}
	}

	public Book findBook(Long id) {
		Book book = new Book(id);
		String query = "SELECT ID, TITLE, DESCRIPTION, UNITCOST, ISBN FROM BOOK WHERE ID = ?";
		
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				book.setTitle(rs.getString("TITLE"));
				book.setDescription(rs.getString("DESCRIPTION"));
				book.setUnitCost(rs.getFloat("UNITCOST"));
				book.setIsbn(rs.getString("ISBN"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return book;
	}

	public void persistBook(Book book) {
		if(bookDoesNotExist(book.getId())){
			String query = "INSERT INTO "+tableName+" (ID, TITLE, DESCRIPTION, UNITCOST, ISBN) VALUES (?, ?, ?, ?, ?)";
			
			try(PreparedStatement stmt = connection.prepareStatement(query)){
				stmt.setLong(1, book.getId());
				stmt.setString(2, book.getTitle());
				stmt.setString(3, book.getDescription());
				stmt.setFloat(4, book.getUnitCost());
				stmt.setString(5, book.getIsbn());
				
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("Book already exists! Cannot persist book: " + book.toString());
		}
	}
	
	private boolean bookDoesNotExist(Long id){
		Book book = findBook(id);
		if(book.getTitle() != null){
			return false;
		}
		return true;
	}
	
	private boolean tableDoesNotExist(final String tableName) throws SQLException{
	    if(connection!=null)
	    {
	        DatabaseMetaData dbmd = connection.getMetaData();
	        ResultSet rs = dbmd.getTables(null, null, tableName.toUpperCase(),null);
	        if(rs.next())
	        {
	            return false;
	        }
	        else
	        {
	            return true;
	        }
	    }
		return true;
	}
	
	private void createTable(final String tableName){
		String query = "Create table "+tableName+" (ID int primary key, TITLE varchar(30), DESCRIPTION varchar(30), UNITCOST varchar(30), ISBN varchar(30))";
		try(PreparedStatement stmt = connection.prepareStatement(query)){
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
