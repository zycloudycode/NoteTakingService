package ws;

import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ws.controller.NoteController;
import ws.model.Note;
import ws.service.NoteService;

@RunWith(SpringRunner.class)
@WebMvcTest(NoteControllerTest.class)
public class NoteControllerTest {
	@Autowired
	private MockMvc mvc;

	@InjectMocks
	private NoteController noteController;

	@Mock
	private NoteService noteService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(noteController).build();
	}

	@Test
	public void getAllNotes() throws Exception {
		Note note = new Note();
		note.setBody("A new note");
		List<Note> allNotes = singletonList(note);
		given(noteService.getNotesByBody(null)).willReturn(allNotes);
		mvc.perform(get("/api/notes").contentType(APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].body", is(note.getBody())));
	}

	@Test
	public void readSuccess() throws Exception {
		Note note = new Note();
		note.setBody("A new note");
		given(noteService.getNote(note.getId())).willReturn(note);
		mvc.perform(get("/api/notes/" + note.getId()).contentType(APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.body", is(note.getBody())));
	}

	//TODO
	//Complete unit tests for controller
	//write unit tests for repository
	//Write integration tests to do black box testing
}
