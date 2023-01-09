package com.formosa.DialogueAlley.repository;

import com.formosa.DialogueAlley.model.HashPostXref;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashPostXrefRepository extends JpaRepository<HashPostXref, Integer> {
}
