package com.formosa.DialogueAlley.repository;

import com.formosa.DialogueAlley.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

//    List<Post> findPostsByAccountId(Integer id);
//
//    List<Post> findPostsByPostHashtagCrossReferenceId(Integer PostHashtagCrossReferenceId);


}
