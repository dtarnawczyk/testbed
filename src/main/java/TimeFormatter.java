import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class TimeFormatter {

    public static String formatDuration(int seconds) {
        if(seconds == 0)
            return "now";
        int year = seconds / 31536000;
        int day = (seconds % 31536000) / 86400;
        int hour = ((seconds % 31536000) % 86400) / 3600;
        int minute = (((seconds % 31536000) % 86400) % 3600) / 60;
        int second = (((seconds % 31536000) % 86400) % 3600) % 60;
        StringBuilder secondsBuilder = new StringBuilder();
        if(second == 1) {
            secondsBuilder.append(second).append(" second");
        } else if( second > 1){
            secondsBuilder.append(second).append(" seconds");
        }
        StringBuilder minutesBuilder = new StringBuilder();
        StringBuilder hoursBuilder = new StringBuilder();
        StringBuilder daysBuilder = new StringBuilder();
        StringBuilder yearsBuilder = new StringBuilder();
        if(seconds > TimeUnit.MINUTES.toSeconds(1)){
            minutesBuilder.append(minute);
            if(minute == 1){
                minutesBuilder.append(" minute");
            }else if(minute > 1) {
                minutesBuilder.append(" minutes");
            }

            if(seconds >= TimeUnit.HOURS.toSeconds(1)){
                hoursBuilder.append(hour);
                if(hour == 1){
                    hoursBuilder.append(" hour");
                }else if(hour > 1) {
                    hoursBuilder.append(" hours");
                }

                if (seconds >= TimeUnit.DAYS.toSeconds(1)){

                    daysBuilder.append(day);
                    if(day == 1){
                        daysBuilder.append(" day");
                    } else if(day > 1){
                        daysBuilder.append(" days");
                    }

                    if(seconds >= TimeUnit.DAYS.toSeconds(365)) {
                        yearsBuilder.append(year);
                        if(year == 1){
                            yearsBuilder.append(" year");
                        }else if(year > 1){
                            yearsBuilder.append(" years");
                        }
                    }
                }
            }
        }
        StringBuilder dateBuilder = new StringBuilder();
        if(year != 0) {
            if (day != 0 || hour != 0 || minute != 0 || second != 0)
                dateBuilder.append(yearsBuilder).append(", ");
            else
                dateBuilder.append(yearsBuilder);
        }

        if(day != 0 ) {
            if(year != 0 && hour == 0 && minute == 0 && second == 0){
                dateBuilder.append(" and ");
            }
            if (hour != 0 || minute != 0 || second != 0)
                dateBuilder.append(daysBuilder).append(", ");
            else
                dateBuilder.append(daysBuilder);
        }

        if(hour != 0) {
            if((day != 0 || year != 0) && minute == 0 && second == 0){
                dateBuilder.append(" and ");
            }
            if ( minute != 0 && second != 0 )
                dateBuilder.append(hoursBuilder).append(", ");
            else
                dateBuilder.append(hoursBuilder);
        }

        if (minute != 0 ) {
            if ((hour != 0 || day != 0 || year != 0) && second == 0) {
                dateBuilder.append(" and ");
            }
            dateBuilder.append(minutesBuilder);
        }

        if(second != 0 ) {
            if(minute != 0 || hour != 0 || day != 0 || year != 0){
                dateBuilder.append(" and ");
            }
            dateBuilder.append(secondsBuilder);
        }

        return dateBuilder.toString();
    }

    @Test
    public void testFormatDurationExamples() {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
        assertEquals("now", TimeFormatter.formatDuration(0));
        assertEquals("182 days, 1 hour, 44 minutes and 40 seconds", TimeFormatter.formatDuration(15731080));

    }
}
