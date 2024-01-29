package com.example.Note_Taking.repository;

import com.example.Note_Taking.model.NoteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
@EnableJpaRepositories
public interface NoteRepository extends JpaRepository<NoteModel, Long> {

}
