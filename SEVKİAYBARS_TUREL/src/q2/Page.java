package q2;

public class Page {
	
	// Parameters
	
	private int no;
	private String content;
	
	
	//Constructors
	
	public Page() // Default Constructor without parameters
	{
		
	}

	public Page(int no, String content) //Constructor with parameters
	{
		super();
		this.no = no;
		this.content = content;
	}

	// Setters and Getters
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	//getInfo Method
	
	public String getInfo() 
	{
		String info = "Page: no:" + no + ", content:Page " + no + " " + content + "\n";
		return info;
	}
	
	
	

}
