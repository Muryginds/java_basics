import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.print.DocFlavor.STRING;

public class Main {

    private static final Calendar CALENDAR_DATE = Calendar.getInstance();
    private static final Calendar CURRENT_DATE = Calendar.getInstance();
    private static final long CURRENT_TIME_IN_MILLIS = CURRENT_DATE.getTime().getTime();
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy - EEE", Locale.US);
    private static final StringBuilder STRING_RESULT = new StringBuilder();

    public static void main(String[] args) {

        int day = 24;
        int month = 8;
        int year = 1988;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        STRING_RESULT.setLength(0);
        CALENDAR_DATE.set(year, month-1, day);
        long timestamp = CALENDAR_DATE.getTime().getTime();
        if (CURRENT_TIME_IN_MILLIS >= timestamp) {
            int days = (int) ((CURRENT_TIME_IN_MILLIS - timestamp) / (24 * 60 * 60 * 1000));
            int years = days/365;
            int i = 0;
            do {
                STRING_RESULT.append(i + " - " + DATE_FORMAT.format(CALENDAR_DATE.getTime()) + System.lineSeparator());
                CALENDAR_DATE.add(Calendar.YEAR, 1);
                if (CALENDAR_DATE.compareTo(CURRENT_DATE) > 0){
                    break;
                }
                i++;
            } while (i <= years);
        }
        return STRING_RESULT.toString();
    }
}