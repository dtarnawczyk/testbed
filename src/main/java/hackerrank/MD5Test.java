package hackerrank;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.util.Base64;
import java.util.Base64;
import java.util.Scanner;

import static java.security.MessageDigest.*;

public class MD5Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        try {
            System.out.println(messageDigest(input, "MD5"));
            System.out.println(messageDigest(input, "SHA-1"));
            System.out.println(messageDigest(input, "SHA-256"));
            System.out.println(input.hashCode());
            System.out.println(Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String messageDigest(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigestMD5 = getInstance(algorithm);
        messageDigestMD5.update(input.getBytes());
        byte[] digest = messageDigestMD5.digest();
        return DatatypeConverter.printHexBinary(digest).toLowerCase();
    }
}
