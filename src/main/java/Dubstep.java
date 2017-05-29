import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Dubstep {

    public static String songDecoder (String song) {
        song = song.replaceAll("WUB+", " ").trim();
        return song.replaceAll("\\s+", " ");
    }


    @Test
    public void Test1() {
        assertEquals("ABC", new Dubstep().songDecoder("WUBWUBABCWUB"));
    }
    @Test
    public void Test2()
    {
        assertEquals("R L", new Dubstep().songDecoder("RWUBWUBWUBLWUB"));
    }
}
