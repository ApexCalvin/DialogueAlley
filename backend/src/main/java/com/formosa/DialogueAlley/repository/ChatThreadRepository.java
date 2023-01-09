package com.formosa.DialogueAlley.repository;

import com.formosa.DialogueAlley.model.ChatThread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatThreadRepository extends JpaRepository<ChatThread, Integer> {
}
