package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.Account;
import com.formosa.DialogueAlley.model.PostHashtagCrossReference;
import com.formosa.DialogueAlley.repository.PostHashtagCrossReferenceRepository;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostHashtagCrossReferenceServicesTest {

    @InjectMocks
    PostHashtagCrossReferenceServices postHashtagCrossReferenceServices = new PostHashtagCrossReferenceServices();

    @Mock
    PostHashtagCrossReferenceRepository postHashtagCrossReferenceRepository;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveCrossReference() {
        PostHashtagCrossReference postHashtagCrossReference = new PostHashtagCrossReference();
        when(postHashtagCrossReferenceRepository.save(any(PostHashtagCrossReference.class))).thenReturn(postHashtagCrossReference);
        postHashtagCrossReferenceServices.saveCrossReference(postHashtagCrossReference);
        verify(postHashtagCrossReferenceRepository).save(postHashtagCrossReference);
    }

    @Test
    void getAllCrossReferences() {
        List<PostHashtagCrossReference> postHashtagCrossReferenceList = new ArrayList<>();
        when(postHashtagCrossReferenceRepository.findAll()).thenReturn(postHashtagCrossReferenceList);
        postHashtagCrossReferenceServices.getAllCrossReferences();
        verify(postHashtagCrossReferenceRepository).findAll();
    }

    @Test
    void getCrossReferenceById() {
        PostHashtagCrossReference postHashtagCrossReference = new PostHashtagCrossReference();
        when(postHashtagCrossReferenceRepository.findById(anyInt())).thenReturn(Optional.of((postHashtagCrossReference)));
        postHashtagCrossReferenceServices.getCrossReferenceById(1);
        verify(postHashtagCrossReferenceRepository).findById(1);
    }

    @Test
    void deleteCrossReferenceById() {
        postHashtagCrossReferenceServices.deleteCrossReferenceById(1);
        verify(postHashtagCrossReferenceRepository).deleteById(1);
    }
}