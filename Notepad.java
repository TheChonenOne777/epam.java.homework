package chapter1;

public class Notepad {

	private Note[] notes;
	
	public Notepad(){
		
		notes = new Note[10];
		
		for(int i = 0; i < notes.length; i++){
			
			notes[i] = new Note("", "");
			
		}
		
	}
	
	public Notepad(int size){
		
		notes = new Note[size];
		
		for(int i = 0; i < notes.length; i++){
			
			notes[i] = new Note("", "");
			
		}
		
	}
	
	public void addNote(Note note){
		
		boolean added = false;
		
		for(Note n : notes){
			
			if(n.getTitle().equals(note.getTitle())){
				
				System.out.println("The note with the same title already exists.");
				
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
	
	public void removeNotes(String title){
		
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
	
	public void readAllNotes(){
		
		for(Note note : notes){
			
			System.out.print(note.toString());
			
		}
		
	}
	
	
	
}
