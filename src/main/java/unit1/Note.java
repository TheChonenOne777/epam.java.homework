package unit1;

/**
 * Stores pair of <code>String</code> values <code>title</code> - <code>constructor</code>.
 */

public class Note {

	private String title;
	private String contents;

    /**
     * Empty constructor. Set <code>title</code> and <code>contents</code> of a note to empty String.
     */
	
	public Note(){
	    title = "";
	    contents = "";
    }

    /**
     * Creates a <code>Note</code> with <code>String</code> values title and contents.
     *
     * @param title         title of the note
     * @param contents      contents of the note
     */

	public Note(String title, String contents) {
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

    /**
     * Returns a pair of <code>title</code> and <code>contents</code> of a note.
     * @return          pair of title and contents
     */

	public String toString(){
		if(!(title.equals("") && contents.equals(""))){
			return("Title: " + title + "\nContents: " + contents + "\n");
		} else {
			return "";
		}
	}
	
}
