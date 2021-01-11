import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {

    public static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-z]+\\@[a-zA-z]+\\.[a-zA-z]+");

    private Set<String> treeSet = new TreeSet<>();

    public void add(String email) {
        if (checkEmailFormat(email)) {
            treeSet.add(email.toLowerCase(Locale.ROOT));
        }
    }

    public List<String> getSortedEmails() {
        List<String> list = new ArrayList<>();
            list.addAll(treeSet);
        return list;
    }

    public static boolean checkEmailFormat(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}