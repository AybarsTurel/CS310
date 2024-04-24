package q1;

import java.time.LocalDateTime;

public class Report implements Printable{
	
	private String title;
	private LocalDateTime reportDate;
	private String text;
	
	
	
	public Report(String title, LocalDateTime reportDate, String text) {
		this.title = title;
		this.reportDate = reportDate;
		this.text = text;
	}



	@Override
	public String getContent() {
		String info = "";
		info = info + "Report [title=" + title + ", text=" + text + ", reportDate=" + reportDate + "]";
		return info;
	}
	
	

}
