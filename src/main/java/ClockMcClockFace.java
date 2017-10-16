import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClockMcClockFace {

    public static String whatTimeIsIt(final double angle) {
        double ang = angle;
        double hour;
        if(ang < 30){
            hour = 12.0;
        } else {
            hour = (ang / 0.5) / 60;
        }
        double minute = Math.floor(((ang % 60) / 0.5) - 60);
        if(minute < 0)
            minute = 60 + minute;
        return String.format("%02d:%02d", (int)hour, (int)minute);
    }

    @Test
    public void test1200() {
        assertEquals("12:00", ClockMcClockFace.whatTimeIsIt(0));
        assertEquals("12:00", ClockMcClockFace.whatTimeIsIt(360));
    }

    @Test
    public void test0300() {
        assertEquals("03:00", ClockMcClockFace.whatTimeIsIt(90));
    }

    @Test
    public void test0600() {
        assertEquals("06:00", ClockMcClockFace.whatTimeIsIt(180));
    }

    @Test
    public void test0900() {
        assertEquals("09:00", ClockMcClockFace.whatTimeIsIt(270));
    }

    @Test
    public void test873438d() {
        assertEquals("02:54", ClockMcClockFace.whatTimeIsIt(87.3438d));
    }

    @Test
    public void test243012d() {
        assertEquals("12:48", ClockMcClockFace.whatTimeIsIt(24.3012d));
    }

    @Test
    public void test285594d() {
        assertEquals("09:31", ClockMcClockFace.whatTimeIsIt(285.594d));
    }
}
