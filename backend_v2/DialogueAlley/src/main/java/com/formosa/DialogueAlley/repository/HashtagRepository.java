package com.formosa.DialogueAlley.repository;

import com.formosa.DialogueAlley.model.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Integer> {
}
