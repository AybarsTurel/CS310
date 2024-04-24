package q2;

import java.util.List;

public class Chapter {
	
	private int no;
	private String title;
	private List<Page> pages;
	
	
	//Constructors
	
	
	public Chapter() 
	{
		
	}
	
	
	public Chapter(int no, String title, List<Page> pages) {
		super();
		this.no = no;
		this.title = title;
		this.pages = pages;
	}



	//Setters and Getters / Encapsulation
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public List<Page> getPages() {
		return pages;
	}


	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	// getInfo Method

	public String getInfo() 
	{
		String info = "Chapter: no: " + no + ", title:" + title + "\n";
		for(Page page : pages) // for every page in  the list
		{
			info = info + page.getInfo();
		}
		return info;
	}
	
	
	
	
	

}
