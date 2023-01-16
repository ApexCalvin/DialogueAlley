package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.Hashtag;
import com.formosa.DialogueAlley.repository.HashtagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HashtagServicesTest {

    @InjectMocks
    HashtagServices hashtagServices = new HashtagServices();

    @Mock
    HashtagRepository hashtagRepository;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveHashtag() {
        Hashtag hashtag = new Hashtag();
        when(hashtagRepository.save(any(Hashtag.class))).thenReturn(hashtag);
        hashtagServices.saveHashtag(hashtag);
        verify(hashtagRepository).save(hashtag);
    }

    @Test
    void getAllHashtags() {
        List<Hashtag> hashtagList = new ArrayList<>();
        when(hashtagRepository.findAll()).thenReturn(hashtagList);
        hashtagServices.getAllHashtags();
        verify(hashtagRepository).findAll();
    }

    @Test
    void getHashtagById() {
        Hashtag hashtag = new Hashtag();
        when(hashtagRepository.findById(anyInt())).thenReturn(Optional.of((hashtag)));
        hashtagServices.getHashtagById(1);
        verify(hashtagRepository).findById(1);
    }

    @Test
    void deleteHashtagById() {
        hashtagServices.deleteHashtagById(1);
        verify(hashtagRepository).deleteById(1);
    }
}