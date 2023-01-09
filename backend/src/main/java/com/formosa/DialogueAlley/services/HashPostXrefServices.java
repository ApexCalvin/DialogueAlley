package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.ChatThread;
import com.formosa.DialogueAlley.model.HashPostXref;
import com.formosa.DialogueAlley.repository.HashPostXrefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HashPostXrefServices {
    @Autowired
    HashPostXrefRepository crossReference;

    public void saveCrossReference(HashPostXref crossRef) { // POST/CREATE
        crossReference.save(crossRef);
    }

    public List<HashPostXref> getAllCrossReferences() { // GET/READ/PLURAL
        return crossReference.findAll();
    }

    public HashPostXref getCrossReferenceById(Integer id) { // GET/READ/SINGULAR
        return crossReference.findById(id).get();
    }

    public void deleteCrossReferenceById(Integer id) { // DELETE/DELETE
        crossReference.deleteById(id);
    }


}
