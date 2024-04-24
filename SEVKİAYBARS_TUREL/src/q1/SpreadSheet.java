package q1;

public class SpreadSheet implements Printable {
	
	private String subject;
	private int numberOfColumns;
	private int numberOfRows;
	
	public SpreadSheet(String subject, int numberOfColumns, int numberOfRows) {
		super();
		this.subject = subject;
		this.numberOfColumns = numberOfColumns;
		this.numberOfRows = numberOfRows;
	}

	@Override
	public String getContent() {
		
		String info = "";
		info = info + "SpreadSheet [subject=" + subject + ", numberOfColumns=" + numberOfColumns + ", numberOfRows=" + numberOfRows + "]";
		
		return info;
	}
	
	
	

}
