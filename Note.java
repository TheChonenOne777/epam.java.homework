package chapter1;

public class Note {

	private String title;
	
	private String contents;
	
	
	public Note(){ }

	public Note(String title, String contents) {
		super();
		this.title = title;
		this.contents = contents;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	
	public String toString(){
		
		if(!(title.equals("") && contents.equals(""))){
		
			return("Title: " + title + "\nContents: " + contents + "\n");
		
		} else {
			
			return "";
			
		}
		
	}
	
}
