import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  private static final Pattern PATTERN = Pattern.compile("\\d+");

  public static void main(String[] args) {
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    System.out.println(calculateSalarySum(text));
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