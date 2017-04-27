package chapter1;

/**
 * A <code>Notepad</code> is a class, which represents a simple notepad.
 * It has a structure of an array, which stores {@link Note} objects.
 * When initialized, it's filled up with empty {@link Note} objects, so no null values are contained.
 *
 * Can not have notes with same <code>title</code>.
 *
 * @author     Vladimir Chertilov
 */

public class Notepad {

	/**
	 * Array for storing notes.
	 */

	private Note[] notes;

	/* Public constructors */

	/**
     * Creates an array of notes.
     * Default number of notes is 10.
     */

	public Notepad(){
		
		notes = new Note[10];

		for(int i = 0; i < notes.length; i++){

			notes[i] = new Note();

		}

	}

	/**
	 * Creates a <code>Notepad</code> object with set number of notes.
     *
     * @param size          number of notes in notepad
	 */
	
	public Notepad(int size){
		
		notes = new Note[size];
		
		for(int i = 0; i < notes.length; i++){
			
			notes[i] = new Note("", "");
			
		}
		
	}


	/**
	 * Adds a <code>Note</code> to a <code>Notepad</code>.
     * No note's <code>title</code> duplicates allowed.
     *
     * @param note          a note to be put in notepad array
	 */
	
	public void addNote(Note note){
		
		boolean added = false;
		
		for(Note n : notes){
			
			if(n.getTitle().equals(note.getTitle())){
				
				System.out.println("The note with the same title already exists.");
				
				break;
				
			} else if(n.getTitle().equals("") && !added){
				
				n.setTitle(note.getTitle());
				n.setContents(note.getContents());
				added = true;
				
			}
				
		}
		
		if(!added){
			
			System.out.println("The notepad is full!");
			
		}
			
	}


    /**
     * Sets note title and contents fields of note to empty String.
     *
     * @param title          A unique for this notepad title of a note to be deleted
     */


    public void removeNote(String title){
		
		int counter = 0;
		
		for(Note note : notes){
			
			if(note.getTitle().equals(title)){
				
				note.setTitle("");
				note.setContents("");
				counter++;
				
			}
			
		}
		
		if(counter == 0){
			
			System.out.println("No notes were removed.");
			
		} else if(counter == 1){
			
			System.out.println("1 note has been removed.");
			
		} else {
			
			System.out.println(counter + " noted have been removed.");
			
		}

	}

    /**
     * Outputs to console all non-empty notes of a <code>Notepad</code>.
     */

	public void readAllNotes(){
		
		for(Note note : notes){
			
			System.out.print(note.toString());
			
		}
		
	}
	
	
	
}
