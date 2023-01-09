package com.formosa.DialogueAlley.controller;

import com.formosa.DialogueAlley.model.Profile;
import com.formosa.DialogueAlley.services.ProfileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/profile")
@CrossOrigin("http://localhost:3000")
public class ProfileController {
    @Autowired
    ProfileServices profileServices;

    @PostMapping("/add")
    public String addProfile(@RequestBody Profile profile) {
        profileServices.saveProfile(profile);
        return "Profile has been created.";
    }

    @GetMapping("/all")
    public List<Profile> getAllProfiles() {
        return profileServices.getAllProfiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Integer id) {
        try {
            Profile profile = profileServices.getProfileById(id);
            return new ResponseEntity<>(profile, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile, @PathVariable Integer id) {
        try{
            profileServices.saveProfile(profile);
            return new ResponseEntity<>(profile, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteProfileById(@PathVariable Integer id) {
        profileServices.deleteProfileById(id);
        return "Profile "+id+" has been deleted.";
    }
}
