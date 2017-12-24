package ws.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ws.model.Note;
import ws.service.NoteService;

@RestController
@RequestMapping(value = "/api/notes")
public class NoteController {
	@Autowired
	NoteService noteService;

	@GetMapping("/{id}")
	public Note read(@PathVariable(value = "id") long id) {
		return noteService.getNote(id);
	}

	@GetMapping
	public List<Note> getNotes(@RequestParam(required = false, value = "query") String query) {
		return noteService.getNotesByBody(query);
	}

	@PostMapping
	public Note create(@Valid @RequestBody Note note) {
		// return the created Note as requested with Status Code OK .
		// Should consider to use ResponseEntity.created(URI) to return 
		return noteService.saveNote(note);
	}

	@PutMapping("/{id}")
	public Note update(@PathVariable(value = "id") long id, @Valid @RequestBody Note note) {
		return noteService.updateNote(id, note);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Note> delete(@PathVariable(value = "id") long id) {
		noteService.deleteNote(id);
		return new ResponseEntity<Note>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	public ResponseEntity<Note> deleteAll() {
		noteService.deleteAllNotes();
		return new ResponseEntity<Note>(HttpStatus.NO_CONTENT);
	}

}
