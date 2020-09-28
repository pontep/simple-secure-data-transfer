package com.example.demo.payload;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class VotePayload {

    @NotNull
    private String username;

    @NotNull
    private String candidateName;

    @NotNull
    private String hash;
}
