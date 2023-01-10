package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.Hashtag;
import com.formosa.DialogueAlley.model.Post;
import com.formosa.DialogueAlley.model.PostHashtagCrossReference;
import com.formosa.DialogueAlley.repository.HashtagRepository;
import com.formosa.DialogueAlley.repository.PostHashtagCrossReferenceRepository;
import com.formosa.DialogueAlley.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServices {
    @Autowired
    PostRepository postRepository;
//    @Autowired
//    HashtagRepository hashtagRepository;
//    @Autowired
//    PostHashtagCrossReferenceRepository crossReferenceRepository;

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

//    public List<Post> findPostsByHashtag(String hashtag) {
//        Hashtag h1 = hashtagRepository.findHashtagByHashtag(hashtag);
//        List<PostHashtagCrossReference> crossRefList = crossReferenceRepository.findPostHashtagCrossReferenceById(h1.getId());
//
//        List<Post> postList = new ArrayList<>();
//
//        for (PostHashtagCrossReference cf : crossRefList) {
//            postList.add(cf.getPost());
//        }
//        return postList;
//    }
}
