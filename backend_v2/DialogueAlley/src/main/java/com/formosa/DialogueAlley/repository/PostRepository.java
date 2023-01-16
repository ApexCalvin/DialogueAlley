package com.formosa.DialogueAlley.repository;

import com.formosa.DialogueAlley.model.DTO.PostListDTO;
import com.formosa.DialogueAlley.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(name = "query_name", nativeQuery = true)
    List<PostListDTO> findPostsByAccountId(String handle);

    @Query(name = "query_name2", nativeQuery = true)
    List<PostListDTO> findPostsByHashtagId(String hashtag);

    @Query(name = "query_name4", nativeQuery = true)
    List<PostListDTO> findPostsDESC();

    @Modifying
    @Query(value = "DELETE FROM post_hashtag_xref WHERE post_id = :postId", nativeQuery = true)
    void removePostHashtagXrefs(int postId);

    @Modifying
    @Query(value = "DELETE FROM comment WHERE post_id = :postId", nativeQuery = true)
    void removeComments(int postId);

    @Modifying
    @Query(value = "DELETE FROM post WHERE post_id = :postId", nativeQuery = true)
    void removePost(int postId);

}
