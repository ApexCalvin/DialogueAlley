package com.formosa.DialogueAlley.controller;

import com.formosa.DialogueAlley.model.PostHashtagCrossReference;
import com.formosa.DialogueAlley.services.PostHashtagCrossReferenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/crossRef")
@CrossOrigin("http://localhost:3000")
public class PostHashtagCrossReferenceController {
    @Autowired
    PostHashtagCrossReferenceServices crossReference;

    @PostMapping("/add")
    public String addCrossRef(@RequestBody PostHashtagCrossReference crossRef) {
        crossReference.saveCrossReference(crossRef);
        return "Cross Reference has been created.";
    }

    @GetMapping("/all")
    public List<PostHashtagCrossReference> getAllCrossRefs() {
        return crossReference.getAllCrossReferences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostHashtagCrossReference> getCrossRefById(@PathVariable Integer id) {
        try {
            PostHashtagCrossReference crossRef = crossReference.getCrossReferenceById(id);
            return new ResponseEntity<>(crossRef, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostHashtagCrossReference> updateCrossRef(@RequestBody PostHashtagCrossReference crossRef, @PathVariable Integer id) {
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
        return "Cross Reference "+id+" has been deleted.";
    }
}
