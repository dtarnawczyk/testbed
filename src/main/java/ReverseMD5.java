import org.junit.Test;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static java.security.MessageDigest.getInstance;
import static org.junit.Assert.assertEquals;

public class ReverseMD5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        try {
            if(Charset.forName("US-ASCII").newEncoder().canEncode(input)) {
                MessageDigest messageDigestMD5 = getInstance("MD5");
                messageDigestMD5.update(input.getBytes());
                byte[] digest = messageDigestMD5.digest();
                StringBuilder builder = new StringBuilder();
                builder.append(DatatypeConverter.printHexBinary(digest).toLowerCase());
                System.out.println(builder.reverse());
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String F(String input) {
        try {
            if(Charset.forName("US-ASCII").newEncoder().canEncode(input) && !input.contains("\n")) {
                MessageDigest messageDigestMD5 = getInstance("MD5");
                messageDigestMD5.update(input.getBytes());
                byte[] digest = messageDigestMD5.digest();
                StringBuilder builder = new StringBuilder();
                builder.append(DatatypeConverter.printHexBinary(digest).toLowerCase());
                return builder.reverse().toString();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Test
    public void test2Invalid() {
        assertEquals("", ReverseMD5.F("√16 = 4"));
        assertEquals("", ReverseMD5.F("Hello, мир!"));
        assertEquals("", ReverseMD5.F("Привет, мир!"));
        assertEquals("", ReverseMD5.F("test string\n"));
    }

    @Test
    public void test1Valid() {
        assertEquals("e7248fce8990089e402b00f89dc8d14d", ReverseMD5.F(""));
        assertEquals("07b432d25170b469b57095ca269bc202", ReverseMD5.F("123"));
        assertEquals("9d986675f0edbed1494f279eb74620e3", ReverseMD5.F("@#$%!"));
        assertEquals("335ea833e623b5e8e8176ed06d4a97a1", ReverseMD5.F("example"));
        assertEquals("93897493c4b060acb45ad0bed6553dc6", ReverseMD5.F("Hello, world!"));
    }
}
