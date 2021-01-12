import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {

  public static final Pattern NAME_PATTERN = Pattern.compile("[A-zА-я|\\s]+");
  public static final Pattern PHONE_PATTERN = Pattern.compile("[7][\\d]{10}");

  public static Scanner scanner = new Scanner(System.in);

  public static String getLine() {
    return scanner.nextLine();
  }

  public static boolean isName(String name) {
    Matcher matcherName = NAME_PATTERN.matcher(name);
    return matcherName.matches();
  }

  public static boolean isPhoneNumber(String number) {
    Matcher matcherPhone = PHONE_PATTERN.matcher(number);
    return matcherPhone.matches();
  }
}
