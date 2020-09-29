package com.example.demo;

import com.example.demo.encryption.AES;
import net.minidev.json.JSONValue;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class Din {
    public static void main(String []args){
        String cipherText = "U2FsdGVkX1/kXla/z0mbpkLW73LtzxTEsq6t0YJn+/e6pNeNurC+imdRIDRpf65PFlOO4tLj/EZzwBTGdgJonOrCFZ+rOIqMA4vAjPNP8B5xGsegtOQuYfbr9tR/nKMFRnwQBZ72mxuY1SSeyfHYgj8x+Wd3fdCTmWBcBCbXjNKjohD2t57R06GaT602JDj6";

        try
        {
            String data = "aK7+UX24ttBgfTnAndz9aQ==" ;
            String key = "1234567812345678";
            String iv = "1234567812345678";

            Base64.Decoder decoder = Base64.getDecoder();
            byte[] encrypted1 = decoder.decode(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            System.out.println(originalString.trim());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
