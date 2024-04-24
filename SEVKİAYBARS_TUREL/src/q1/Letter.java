package q1;

public class Letter implements Printable{
	
	private String sender;
	private String receiver;
	private String textContent;

	
	
	public Letter(String sender, String receiver, String textContent) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.textContent = textContent;
	}



	@Override
	public String getContent() {
		String info = "";
		info = info + "Letter [sender=" + sender + ", receiver=" + receiver + ", textContent=" + textContent + "]";
		return info;
	}

}
