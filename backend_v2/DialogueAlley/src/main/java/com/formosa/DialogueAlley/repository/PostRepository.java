package com.formosa.DialogueAlley.repository;

import com.formosa.DialogueAlley.model.DTO.PostListDTO;
import com.formosa.DialogueAlley.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(name = "query_name", nativeQuery = true)
    List<PostListDTO> findPostsByAccountId(String handle);

    @Query(name = "query_name2", nativeQuery = true)
    List<PostListDTO> findPostsByHashtagId(String hashtag);

//    List<Post> findPostsByPostHashtagCrossReferenceId(Integer PostHashtagCrossReferenceId);


}
