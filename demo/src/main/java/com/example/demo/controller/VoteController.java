package com.example.demo.controller;

import com.example.demo.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    @GetMapping("/test")
    public String getTest(){
        return "WTF are you looking for?!";
    }

    @PostMapping("/vote")
    public ResponseEntity<?> newVote(@RequestBody String encryptedBody){
        System.out.println("Received: "+encryptedBody.toString());
//        Alice alice = new Alice()
        return ResponseEntity.ok().body("Vote successfully.");
    }
}
