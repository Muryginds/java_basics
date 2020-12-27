import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    System.out.println(calculateSalarySum(text));
  }

  public static int calculateSalarySum(String text){

    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(text);
    int sum = 0;
    while(matcher.find())
      sum += Integer.parseInt(matcher.group());

    return sum;
  }
}