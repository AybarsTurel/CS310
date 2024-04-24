package q1;

public class FilePrinter extends Printer{
	
	private String fileName;
	
	

	public FilePrinter(String fileName) {
		super();
		this.fileName = fileName;
	}



	@Override
	public void printOut(Printable printable) {
		System.out.println("Data printed to file:" + fileName + " :");
		System.out.println(printable.getContent());
		
	}



	

}
