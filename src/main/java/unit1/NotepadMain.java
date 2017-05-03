package unit1;

public class NotepadMain {

	public static void main(String[] args) {
		
		Notepad notepad = new Notepad(3);
		
		Note note1 = new Note("Test", "This is a test note.");
		
		Note note2 = new Note("Test", "This is a test note.");
		
		Note note3 = new Note("Greetings", "Hello World");
		
		Note note4 = new Note("My phone number", "9219318347");
		
		notepad.addNote(note1);
		
		notepad.readAllNotes();
		
		System.out.println();
		
		notepad.addNote(note2);
		
		notepad.readAllNotes();
		
		System.out.println();
		
		notepad.addNote(note3);
		
		notepad.addNote(note4);
		
		notepad.readAllNotes();
		
		System.out.println();
		
		notepad.removeNote("Test");
		
		notepad.readAllNotes();
		
		//System.out.println(note1.toString());
		
	}
	
}
