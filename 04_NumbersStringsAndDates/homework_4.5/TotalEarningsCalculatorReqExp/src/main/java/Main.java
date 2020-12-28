import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  private static final String INCOME_TEXT = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
  private static final String REGEX_TO_FIND_DIGIT = "\\d+";
  private static final Pattern PATTERN = Pattern.compile(REGEX_TO_FIND_DIGIT);

  public static void main(String[] args) {
    System.out.println(calculateSalarySum(INCOME_TEXT));
  }

  public static int calculateSalarySum(String text){
    Matcher matcher = PATTERN.matcher(text);
    int sum = 0;
    while(matcher.find()){
      sum += Integer.parseInt(matcher.group());
    }
    return sum;
  }
}