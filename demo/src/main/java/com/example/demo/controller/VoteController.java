package com.example.demo.controller;

import com.example.demo.encryption.AES;
import com.example.demo.repository.VoteRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Encryption;
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

        String decrypted = AES.decrypt(encryptedBody.toString(), "pontep1234");
        System.out.println("Decrypted: " + decrypted);
        return ResponseEntity.ok().body("Vote successfully.");
    }
}
