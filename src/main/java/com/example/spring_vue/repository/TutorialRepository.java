package com.example.spring_vue.repository;

import java.util.List;

import com.example.spring_vue.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    public List<Tutorial> findByPublished(boolean published);
    public List<Tutorial> findByTitleContaining(String title);
}
