import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern PATTERN = Pattern.compile("<.+?>");
    private static final String INPUT_TEXT = "Номер кредитной карты <4008> 1234 <5678> 8912";

    public static void main(String[] args) {

    System.out.println(searchAndReplaceDiamonds(INPUT_TEXT, "***"));
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.replaceAll(placeholder);
        }
        else {
            return text;
        }
    }
}