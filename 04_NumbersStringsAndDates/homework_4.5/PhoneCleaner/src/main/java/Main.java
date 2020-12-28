import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  private static final Pattern PATTERN_FOR_NORMALIZATION = Pattern.compile("\\s*(\\s|\\W)\\s*");
  private static final Pattern PATTERN_TO_CHECK_NUMBER = Pattern.compile("[7,8]{1}[0-9]{7,10}");

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
    Matcher matcherForNormalization = PATTERN_FOR_NORMALIZATION.matcher(input);
    String firstResult = matcherForNormalization.replaceAll("");

    int firstSymbol = firstResult.indexOf("8");

    if ((firstResult.length() == 10)) {
      firstResult = "7".concat(firstResult);
    } else if ((firstResult.length() == 11 && firstSymbol == 0)) {
      firstResult = "7".concat(firstResult.substring(1,firstResult.length()));
    }

    Matcher matcherCheckNumber = PATTERN_TO_CHECK_NUMBER.matcher(firstResult);

    if (matcherCheckNumber.matches()) {
      System.out.println(matcherCheckNumber.group());
    } else {
      System.out.println("Неверный формат номера");
    }
  }
}