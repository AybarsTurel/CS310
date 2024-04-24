package q2;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	
	public static void main(String args[]) 
	{
		//Initialize  four page objects
		Page page1 = new Page(1, "Content_1");
		Page page2 = new Page(2, "Content_2");
		Page page3 = new Page(3, "Content_3");
		Page page4 = new Page(4, "Content_4");
		
		//Page page5 = new Page(5, "Content_5");
		//Page page6 = new Page(6, "Content_6");
		//Page page7 = new Page(7, "Content_7");
		
		
		// I grouped pages in list because chapter take pages as a list.
		List<Page> pages1 = new ArrayList<>();
		pages1.add(page1);
		pages1.add(page2);
	
		List<Page> pages2 = new ArrayList<>();
		pages2.add(page3);
		pages2.add(page4);
		
		
		/*
		List<Page> pages3 = new ArrayList<>();
		pages3.add(page5);
		pages3.add(page6);
		pages3.add(page7);
		*/
		
	
		Chapter chapter1 = new Chapter(1, "First Chapter", pages1);
		Chapter chapter2 = new Chapter(2, "Second Chapter", pages2);
		//Chapter chapter3 = new Chapter(3, "Third Chapter", pages3);
		
		
		// I grouped chapter as list because book takes chapters as a list. Even if it takes one chapter it has to be in the list. 
		List<Chapter> chapters1 = new ArrayList<>();
		List<Chapter> chapters2 = new ArrayList<>();
		
		
		
		//Initialize two chapter objects having different chapter
		chapters1.add(chapter1);
		chapters2.add(chapter2);
		//chapters2.add(chapter3);
	
		// Initialize two book having one different chapter
		Book book1 = new Book("Grapes of Wrath", "Fore word of Grapes of Wrath", chapters1);
		Book book2 = new Book("Introduction to Java", "Fore word of Intro to Java", chapters2);
		
		// I grouped books as a list because bookshelf takes books in the list.
		List<Book> books1 = new ArrayList<>();
		books1.add(book1);
		books1.add(book2);
		
		//Initialize a bookshelf with two different books
		BookShelf bookshelf = new BookShelf(books1);
		
		System.out.println("----Summary of bookshelf----");
		
		System.out.println(bookshelf.getInfo());
		
		System.out.println("----Picked Book Information----");
		
		Book pickUpBook = bookshelf.getBook(1); // It checks that the user enter the valid index number. If index number is not valid for list it will not return anything.
		
		if(pickUpBook != null) 
		{
			System.out.println("Pick up book:" + pickUpBook.getInfo());
		}
		
		
	}
	

	
	
}
