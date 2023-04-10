package org.carworkshop.helpers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Hash {

    public static String createHash(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashpass = digest.digest(password.getBytes(StandardCharsets.UTF_8));

        byte[] encoded = Base64.getEncoder().encode(Arrays.toString(hashpass).getBytes());

        return new String(encoded);
    }
}
