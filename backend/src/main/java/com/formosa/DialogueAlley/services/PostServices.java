package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.Post;
import com.formosa.DialogueAlley.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServices {

    @Autowired
    PostRepository postRepository;

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Integer id) {
        return postRepository.findById(id).get();
    }

    public void deletePostById(Integer id) {
        postRepository.deleteById(id);
    }



}
