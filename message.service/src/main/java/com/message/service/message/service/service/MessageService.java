package com.message.service.message.service.service;


import com.google.common.base.Strings;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class MessageService {
    // Java program to calculate SHA hash value
    public String saveMessageData(String msg )  {
        MessageDigest messageDigest = null;
        String result = null;
        //getInstance method is called with hashing SHA
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(msg.getBytes(StandardCharsets.UTF_8));
            result = bytesToHex(hash);

         }catch(NoSuchAlgorithmException e){

        }
        // to calculate message digest String
        // return array of byte
        return result.toLowerCase();
    }
    /**
     * Use javax.xml.bind.DatatypeConverter class in JDK to convert byte array
     * to a hexadecimal string. Note that this generates hexadecimal in upper case.
     * @param hash
     * @return
     */
    private String  bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    }

    // import com.google.common.base.Strings;
    /**
     * Demonstrate checking for String that is not null, not empty, and not white
     * space only using Guava.
     *
     * @param string String to be checked for not null, not empty, and not white
     *    space only.
     * @return {@code true} if provided String is not null, is not empty, and
     *    has at least one character that is not considered white space.
     */
    public static boolean isNotNullNotEmptyNotWhiteSpaceOnlyByGuava(final String string)
    {
        return !Strings.isNullOrEmpty(string) && !string.trim().isEmpty();
    }
}
