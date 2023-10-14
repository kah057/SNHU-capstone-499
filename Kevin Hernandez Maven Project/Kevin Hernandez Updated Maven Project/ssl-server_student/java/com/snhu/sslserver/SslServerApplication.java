/**
 * File: SslServerApplication.java
 * Author: [Kevin Hernandez]
 * Date: [9/28/2023]
 * Version: 1.0
 * Description: This file contains the main method to launch the SSL server application. 
 *              It is responsible for initializing the Spring Boot application.
 */
package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class SslServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SslServerApplication.class, args);  // Launch the Spring Boot application
    }

}

/**
 * Class: ServerController
 * Description: This class contains the REST controller that handles HTTP requests to the "/hash" endpoint. 
 *              It provides a method to compute the SHA-256 hash of a given string and return it as a hex string.
 */
@RestController
class ServerController {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    /**
     * Method: getHash
     * Description: This method computes and returns the SHA-256 hash of the input string.
     * @param input The string to be hashed.
     * @return The SHA-256 hash of the input string as a hex string.
     */
    private String getHash(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] messageDigestSHA256 = messageDigest.digest(input.getBytes());  // Update to use input string
            return bytesToHex(messageDigestSHA256);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return input;
    }

    /**
     * Method: bytesToHex
     * Description: This method converts a byte array to a hex string.
     * @param bytes The byte array to be converted.
     * @return The hex string representation of the byte array.
     */
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     * Endpoint: /hash
     * Description: This endpoint computes and returns the SHA-256 hash of a hardcoded string.
     * @return HTML formatted string containing the original data and its SHA-256 hash.
     */
    @RequestMapping("/hash")
    public String myHash() {
        String data = "Kevin's Check Sum!!";
        String hash = getHash(data);
        return "<p>data: " + data + "</p><p> Name of Cipher Used: SHA-256 Value: " + hash + "</p>";
    }
}
