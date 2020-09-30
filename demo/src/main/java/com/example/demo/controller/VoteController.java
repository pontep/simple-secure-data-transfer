package com.example.demo.controller;
import com.example.demo.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import java.util.Base64;


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

        try
        {
            System.out.println("received: " + encryptedBody);

//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7PADDING");
//            cipher.init(Cipher.DECRYPT_MODE, "dinza");
//            String result = cipher.doFinal(Base64.getDecoder().decode(strToDecrypt));
            return ResponseEntity.ok().body("Vote successfully.");
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("vote error.");
        }

    }
}
