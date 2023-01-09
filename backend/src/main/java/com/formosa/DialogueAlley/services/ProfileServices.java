package com.formosa.DialogueAlley.services;

import com.formosa.DialogueAlley.model.Profile;
import com.formosa.DialogueAlley.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServices {
    @Autowired
    ProfileRepository profileRepository;

    public void saveProfile(Profile profile) { // POST/CREATE
        profileRepository.save(profile);
    }

    public List<Profile> getAllProfiles() { // GET/READ/PLURAL
        return profileRepository.findAll();
    }

    public Profile getProfileById(Integer id) { // GET/READ/SINGULAR
        return profileRepository.findById(id).get();
    }

    public void deleteProfileById(Integer id) { // DELETE/DELETE
        profileRepository.deleteById(id);
    }
}
