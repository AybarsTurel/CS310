package q2;

import java.util.List;

public class BookShelf {
	
	private List<Book> books;

	
	//Constructors
	public BookShelf() 
	{
	}
	
	
	public BookShelf(List<Book> books) 
	{
		super();
		this.books = books;
	}
	
	//Setters and Getters

	public List<Book> getBooks() 
	{
		return books;
	}

	public void setBooks(List<Book> books) 
	{
		this.books = books;
	}
	
	private int getTotalNumberOfBooks()
	{
		int totalBooks = 0;
		for(Book book:books) 
		{
			totalBooks++;
		}
		return totalBooks;
	}
	
	public Book getBook(int index) // It will find the book object at the list according to index.
	{
		Book chosenBook = null; // If the user did not enter valid index, it will return null to indicate there is no object in that index.
		if(index <= getTotalNumberOfBooks()-1) // It will check the given index in the list size. 
		{
			chosenBook = books.get(index); // It will set the object according to index.
		}
		return chosenBook;
		
	}
	
	// getInfo Method
	
	public String getInfo() 
	{
		String info = "Bookshelf:" + "\n";
		info = info + "Total number of books:" +getTotalNumberOfBooks() + "\n" + "\n";
		for(Book book:books) 
		{
			info = info + book.getInfo()+"\n";
		}
		
		return info;
	}
	
	

}
