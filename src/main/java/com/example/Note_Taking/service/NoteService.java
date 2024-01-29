package com.example.Note_Taking.service;

import com.example.Note_Taking.DTO.NoteDTO;
import com.example.Note_Taking.model.NoteModel;
import com.example.Note_Taking.repository.NoteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public void createNote(NoteDTO noteDTO) {

        NoteModel noteDTO1 = new NoteModel();
        noteDTO1.setNoteTopic(noteDTO.getNoteTopic());
        noteDTO1.setNoteBody(noteDTO.getNoteBody());
        noteRepository.save(noteDTO1);
    }

    public List<NoteModel> findAllUsers() {
        return noteRepository.findAll();
    }

    public void deleteNote(Long id) {
        if(id == null){
            throw new EntityNotFoundException("Note with id " + id + " not found");
        }
        noteRepository.deleteById(id);
    }

    public void updateNote(NoteDTO noteDTO, Long id) {
        if (!(id != null && noteRepository.existsById(id))) {
            throw new EntityNotFoundException("Note with id " + id + " not found");
        }
        NoteModel noteModel = new NoteModel();
        noteModel.setNoteTopic(noteDTO.getNoteTopic());
        noteModel.setNoteBody(noteDTO.getNoteBody());
        noteModel.setNoteID(id);
        noteRepository.save(noteModel);
    }
}
