package com.formosa.DialogueAlley.controller;

import com.formosa.DialogueAlley.model.HashPostXref;
import com.formosa.DialogueAlley.services.HashPostXrefServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/crossRef")
@CrossOrigin("http://localhost:3000")
public class HashPostXrefController {

    @Autowired
    HashPostXrefServices crossReference;

    @PostMapping("/add")
    public String addCrossRef(@RequestBody HashPostXref crossRef) {
        crossReference.saveCrossReference(crossRef);
        return "Profile has been created.";
    }

    @GetMapping("/all")
    public List<HashPostXref> getAllCrossRefs() {
        return crossReference.getAllCrossReferences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashPostXref> getCrossRefById(@PathVariable Integer id) {
        try {
            HashPostXref crossRef = crossReference.getCrossReferenceById(id);
            return new ResponseEntity<>(crossRef, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashPostXref> updateCrossRef(@RequestBody HashPostXref crossRef, @PathVariable Integer id) {
        try{
            crossReference.saveCrossReference(crossRef);
            return new ResponseEntity<>(crossRef, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteCrossRefById(@PathVariable Integer id) {
        crossReference.deleteCrossReferenceById(id);
        return "crossReference "+id+" has been deleted.";
    }
}
