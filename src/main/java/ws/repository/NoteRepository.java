package ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
	List<Note> findByBodyLikeIgnoreCase(String keyWord);
}
