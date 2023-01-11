package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.Account;
import com.formosa.DialogueAlley.model.DTO.PostSaveDTO;
import com.formosa.DialogueAlley.model.Hashtag;
import com.formosa.DialogueAlley.model.Post;
import com.formosa.DialogueAlley.model.PostHashtagCrossReference;
import com.formosa.DialogueAlley.repository.AccountRepository;
import com.formosa.DialogueAlley.repository.HashtagRepository;
import com.formosa.DialogueAlley.repository.PostHashtagCrossReferenceRepository;
import com.formosa.DialogueAlley.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServices {
    @Autowired
    PostRepository postRepository;
    @Autowired
    AccountRepository accountRepository;
//    @Autowired
//    HashtagRepository hashtagRepository;
//    @Autowired
//    PostHashtagCrossReferenceRepository crossReferenceRepository;

    public boolean savePost(PostSaveDTO post) {

        Optional<Account> account = accountRepository.findById(post.getAccount_id());

        if (account.isPresent()) {
            Post post1 = new Post();
            post1.setAssoc_account(account.get());

            if(post.getDate_time() != null) {
                post1.setDate_time(post.getDate_time());
            }else {
                post1.setDate_time(new Date());
            }

            post1.setMessage(post.getMessage());
            postRepository.save(post1);
            return true;
        }

        return false;
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
