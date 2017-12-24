package ws.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ws.errorHandling.DataNotFoundException;
import ws.model.Note;
import ws.repository.NoteRepository;

@Service
@Transactional
public class NoteService implements NoteServiceInterface {
	@Autowired
	NoteRepository noteRepo;

	@Override
	public Note saveNote(Note note) {
		return noteRepo.save(note);
	}

	@Override
	public Note getNote(long id) {
		if (!noteExists(id)) {
			throw new DataNotFoundException();
		}
		return noteRepo.findOne(id);
	}

	@Override
	public List<Note> getAllNotes() {
		return noteRepo.findAll();
	}

	// Assuming key word do not need to be case sensitive
	public List<Note> getNotesByBody(String query) {
		List<Note> notes;
		if (query != null && !"".equals(query)) {
			notes = noteRepo.findByBodyLikeIgnoreCase("%" + query + "%");
		} else {
			notes = noteRepo.findAll();
		}
		return notes;
	}

	@Override
	public Note updateNote(long id, Note newNote) {
		Note note = getNote(id);
		note.setBody(newNote.getBody());
		return noteRepo.save(note);
	}

	@Override
	public void deleteNote(long id) {
		if (!noteExists(id)) {
			throw new DataNotFoundException();
		}
		noteRepo.delete(id);
	}

	public void deleteAllNotes() {
		noteRepo.deleteAll();
	}
	
	public boolean noteExists(long id) {
		return noteRepo.exists(id);
	}

}
