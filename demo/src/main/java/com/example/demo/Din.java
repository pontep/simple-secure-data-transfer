package com.example.demo;

import com.example.demo.encryption.AES;

public class Din {
    public static void main(String []args){
        AES.setKey("64");
        String en = AES.encrypt("Pontep", "1234");
        String de = AES.decrypt(en, "1234");
        System.out.println("en = "+ en);
        System.out.println("de = "+ de);
    }
}
