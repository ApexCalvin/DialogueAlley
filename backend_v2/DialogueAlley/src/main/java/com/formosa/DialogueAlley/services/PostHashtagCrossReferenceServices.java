package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.PostHashtagCrossReference;
import com.formosa.DialogueAlley.repository.PostHashtagCrossReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostHashtagCrossReferenceServices {
    @Autowired
    PostHashtagCrossReferenceRepository crossReference;

    public void saveCrossReference(PostHashtagCrossReference crossRef) { // POST/CREATE
        crossReference.save(crossRef);
    }

    public List<PostHashtagCrossReference> getAllCrossReferences() { // GET/READ/PLURAL
        return crossReference.findAll();
    }

    public PostHashtagCrossReference getCrossReferenceById(Integer id) { // GET/READ/SINGULAR
        return crossReference.findById(id).get();
    }

    public void deleteCrossReferenceById(Integer id) { // DELETE/DELETE
        crossReference.deleteById(id);
    }
}
