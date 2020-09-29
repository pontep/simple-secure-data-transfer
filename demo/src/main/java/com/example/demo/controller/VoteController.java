package com.example.demo.controller;

import com.example.demo.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
        AliceContext aliceContext = new AliceContextBuilder()
                .setAlgorithm(AliceContext.Algorithm.AES)
                .setMode(AliceContext.Mode.CBC) // or AliceContext.Mode.CTR
                .setIvLength(16)
                .build();
        Alice alice = new Alice(aliceContext);
        try{
            String decryptedBytes = alice.decrypt(encryptedBody.getBytes(), "pontep1234".toCharArray()).toString();
            System.out.println("Decrypted: " + decryptedBytes);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body("Vote successfully.");
    }
}
