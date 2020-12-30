import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  private static final Pattern PATTERN = Pattern.compile("\\+?[7,8]{1}(\\D)*(\\d{3})(\\D)*(\\d{3})(\\D)*(\\d{2})(\\D)*(\\d{2})\\b");
  private static final Pattern PATTERN_SEVEN_NUMBERS = Pattern.compile("^(\\d{3})(\\D)*(\\d{3})(\\D)*(\\d{2})(\\D)*(\\d{2})\\b");

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      checkStringIsValid(input);
    }
  }

  private static void checkStringIsValid(String input) {

    Matcher matcher = PATTERN.matcher(input);
    Matcher matcherSevenNumbers = PATTERN_SEVEN_NUMBERS.matcher(input);

    if (matcher.matches()) {
      System.out.println(matcher.replaceAll("7$2$4$6$8"));
    } else if (matcherSevenNumbers.matches()){
      System.out.println(matcherSevenNumbers.replaceAll("7$1$3$5$7"));
    } else {
      System.out.println("Неверный формат номера");
    }
  }
}