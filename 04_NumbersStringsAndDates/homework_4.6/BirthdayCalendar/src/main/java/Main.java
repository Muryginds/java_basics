import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    private static final DateTimeFormatter PRINT_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEE", new Locale("us"));
    private static final StringBuilder STRING_RESULT = new StringBuilder();
    private static final int BIRTHDATE_DAY = 24;
    private static final int BIRTHDATE_MONTH = 8;
    private static final int BIRTHDATE_YEAR = 1988;
    private static final LocalDate TODAY = LocalDate.now();

    public static void main(String[] args) {

        System.out.println(collectBirthdays(BIRTHDATE_YEAR, BIRTHDATE_MONTH, BIRTHDATE_DAY));
    }

    public static String collectBirthdays(int year, int month, int day) {

        STRING_RESULT.setLength(0);
        LocalDate birthdate = LocalDate.of(year, month, day);
        int i = 0;
        while (!TODAY.isBefore(birthdate)) {
          STRING_RESULT.append(i + " - " + birthdate.format(PRINT_FORMAT) + System.lineSeparator());
          birthdate = birthdate.plusYears(1);
          i++;
          }
        return STRING_RESULT.toString();
    }
}