package q1;

import java.time.LocalDateTime;

public class main {
	
	// I simply follow the instructions.
	
	public static void main(String[] args) 
	{
		LocalDateTime reportTime =  LocalDateTime.of(2022, 01, 04, 01, 13);
		
		Report report = new Report("Final Exam",reportTime,"I am trying to complete the question, yeah still!");
		SpreadSheet spreadSheet = new SpreadSheet("Budget", 10,10);
		Letter letter = new Letter("Jack", "Henry", "Letter content");
		
		
		
		
		FilePrinter filePrinter = new FilePrinter("output1.txt");
		ConsolePrinter consolePrinter = new ConsolePrinter();
		
		
		filePrinter.addDocument(report);
		filePrinter.addDocument(spreadSheet);
		filePrinter.addDocument(letter);
		
		
		consolePrinter.addDocument(report);
		consolePrinter.addDocument(spreadSheet);
		consolePrinter.addDocument(letter);
		
		filePrinter.printAllDocuments();
		consolePrinter.printAllDocuments();
		
		
	}
	
	
	
	

}
