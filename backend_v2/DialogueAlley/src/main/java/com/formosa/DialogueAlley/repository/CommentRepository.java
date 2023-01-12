package com.formosa.DialogueAlley.repository;

import com.formosa.DialogueAlley.model.Comment;
import com.formosa.DialogueAlley.model.DTO.PostListDTO;
import com.formosa.DialogueAlley.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(name = "query_name3", nativeQuery = true)
    List<PostListDTO> findAllCommentsByPostId(Integer id);
}
