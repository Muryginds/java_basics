import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  private static final Pattern PATTERN_TO_CHECK_INPUT = Pattern.compile("(^[а-яА-Я-]{1,} [а-яА-Я-]{1,} [а-яА-Я-]{1,})(\\s+[а-я]+)?$");
  private static final Pattern PATTERN_TO_CORRECT_OUTPUT = Pattern.compile("\\s*(\\s)\\s*");

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
    Matcher matcherCheckInput = PATTERN_TO_CHECK_INPUT.matcher(input);
    if (matcherCheckInput.find()) {
      String[] names = PATTERN_TO_CORRECT_OUTPUT.split(matcherCheckInput.group(0));
      System.out.println("Фамилия: " + names[0]);
      System.out.println("Имя: " + names[1]);
      if (names.length == 4) {
        System.out.println("Отчество: " + names[2] + " " +names[3]);
      } else {
        System.out.println("Отчество: " + names[2]);
      }

    } else {
      System.out.println("Введенная строка не является ФИО");
    }
  }
}