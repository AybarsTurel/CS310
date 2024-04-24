package q2;

import java.util.List;

public class Book {
	
	private String title;
	private String foreWord;
	private List<Chapter> chapters;
	
	//Constructors
	
	public Book() 
	{
		
	}
	
	public Book(String title, String foreWord, List<Chapter> chapters) {
		super();
		this.title = title;
		this.foreWord = foreWord;
		this.chapters = chapters;
	}


	


	//Setter and Getters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getForeWord() {
		return foreWord;
	}

	public void setForeWord(String foreWord) {
		this.foreWord = foreWord;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	//Get Number Of Pages
	
	public int getNumberOfPages() 
	{
		int totalPage = 0;
		for(Chapter chapter: chapters) // It will look every single chapters in chapters list.
		{
			for(Page page:chapter.getPages()) // After taking a chapter, it will count the number of pages in the certain chapter.
			{
				totalPage++;
			}
		}
		return totalPage;
	}
	
	public String getInfo() 
	{
		String info = "Book: title:" + title + ", foreWord:" + foreWord + "\n";
		info = info + "Total number of pages: " +  getNumberOfPages() + "\n";
		for(Chapter chapter: chapters) // It will add chapter info one by one because one book can have several chapters.
		{
			info = info + chapter.getInfo();
		}
		
		return info;
	}
	
	
	

}
