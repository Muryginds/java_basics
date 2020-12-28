import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  private static final String REGEX_TO_CLEAR_DIGITS_AND_QUOTES = "\\s*(\"|[0-9])\\s*";
  private static final String REGEX_TO_SPLIT_WORDS = "\\s*(\\s|,|!|\\.|-|;|\")\\s*";
  private static final Pattern PATTERN_ONE = Pattern.compile(REGEX_TO_CLEAR_DIGITS_AND_QUOTES);
  private static final Pattern PATTERN_TWO = Pattern.compile(REGEX_TO_SPLIT_WORDS);
  private static final String INPUT_TEXT = "The fate of the spending package remains in the balance while Mr Trump refuses to sign it.\n"
      + "\n"
      + "He spent Saturday at his Mar-a-Lago residence in Florida with his family, where he held \"many meetings and calls\", according to his schedule.\n"
      + "\n"
      + "The White House said it had no update on the prospect of Mr Trump signing the bill by Monday, an official quoted by Reuters news agency said.\n"
      + "\n"
      + "Because it includes money to fund the federal government through September 2021s, a government shutdown looms on Tuesday unless a stopgap bill is passed and signed by the president.\n"
      + "\n"
      + "But that would not cover the coronavirus aid package, leaving millions of families in peril.\n"
      + "\n"
      + "Earl McCarthy, a father of four from Georgia who lost his sales job earlier this year, told the Associated Press that he was facing the prospect of having no income by the second week of January.\n"
      + "\n"
      + "He said he had already relied on his savings for five months while waiting to receive $350 a week in unemployment benefits. \"It's going to be difficult if the president doesn't sign this bill,\" he said.\n"
      + "\n"
      + "The House of Representatives, controlled by the Democrats, plans to vote on Monday on a standalone bill that would provide the $2,000 cheques to Americans.\n"
      + "\n"
      + "On the same day, the House is also expected to vote on an unrelated, $740bn defence spending bill, which Mr Trump vetoed on Wednesday instead of signing into law. Lawmakers plan to override the president's veto and enact the legislation anyway, but to do so they need two-thirds of votes in both the House and Senate";



  public static void main(String[] args) {
  System.out.println(splitTextInToWords(INPUT_TEXT));
  }

  public static String splitTextInToWords(String text) {
    Matcher matcherOne = PATTERN_ONE.matcher(text);
    String newStr = matcherOne.replaceAll(" ");

    Matcher matcherTwo = PATTERN_TWO.matcher(newStr);
    newStr = matcherTwo.replaceAll("\n");

    return newStr.trim();
  }

}