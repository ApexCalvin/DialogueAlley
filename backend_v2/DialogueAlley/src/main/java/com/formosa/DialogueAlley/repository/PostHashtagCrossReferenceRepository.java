package com.formosa.DialogueAlley.repository;

import com.formosa.DialogueAlley.model.PostHashtagCrossReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostHashtagCrossReferenceRepository extends JpaRepository<PostHashtagCrossReference, Integer> {
}
