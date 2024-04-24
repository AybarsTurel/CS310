package q1;

import java.util.ArrayList;

public abstract class Printer {
	
	private ArrayList<Printable> docs = new ArrayList<>();
	
	public abstract void printOut(Printable printable);
	
	public void addDocument(Printable printable) 
	{
		docs.add(printable);
	}
	
	public void printAllDocuments() 
	{
		for(Printable doc : docs) 
		{
			printOut(doc);
		}
	}

}
