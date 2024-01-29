package com.example.Note_Taking.controller;

import com.example.Note_Taking.DTO.NoteDTO;
import com.example.Note_Taking.model.NoteModel;
import com.example.Note_Taking.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NoteController {

    private final NoteService noteService;

    //Post Request
    @PostMapping(path = "/create")
    public ResponseEntity createNote(@RequestBody NoteDTO noteDTO){
        noteService.createNote(noteDTO);
        return ResponseEntity.ok().build();
    }

    //Get Request
    @GetMapping(path = "/getAllNotes")
    public ResponseEntity<List<NoteModel>> getAllUsers(){
        List<NoteModel> notes = noteService.findAllUsers();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    //Delete Request
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }

    //Update Request
    @PutMapping(path = "/update/{id}")
    public ResponseEntity updateNote(
            @PathVariable Long id,
            @RequestBody NoteDTO noteDTO){
        noteService.updateNote(noteDTO, id);
        return ResponseEntity.ok().build();
    }

}
