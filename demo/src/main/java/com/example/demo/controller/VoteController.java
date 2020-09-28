package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class VoteController {

    @GetMapping("/test")
    public String getTest(){
        return "WTF are you looking for?!";
    }

    @PostMapping("/vote")
    public ResponseEntity<?> newVote(@RequestBody Objects payload){
        return ResponseEntity.ok().body("Vote successfully.");
    }
}
