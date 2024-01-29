package com.example.Note_Taking.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Note")
public class NoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long noteID;

    public String noteTopic;
    public String noteBody;
}
