package ws.service;

import java.util.List;

import ws.model.Note;

public interface NoteServiceInterface {
	Note saveNote(Note note);

	Note getNote(long id);

	List<Note> getAllNotes();

	Note updateNote(long id, Note note);

	void deleteNote(long id);
}
