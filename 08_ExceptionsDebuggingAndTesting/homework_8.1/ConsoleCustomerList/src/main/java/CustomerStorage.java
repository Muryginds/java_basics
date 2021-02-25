import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;
    private static final Pattern MAIL_PATTERN = Pattern.compile("\\S+\\@\\S+\\.\\S+");
    private static final Pattern PHONE_PATTERN = Pattern.compile("\\+[7,8]{1}\\d{10}");

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong input format. Correct input example: \n"
                + "\"add Василий Петров vasily.petrov@gmail.com +79215637722\"");
        }
        Matcher mailMatcher = MAIL_PATTERN.matcher(components[INDEX_EMAIL]);
        Matcher phoneMatcher = PHONE_PATTERN.matcher(components[INDEX_PHONE]);

        if (!mailMatcher.matches()){
            throw new IllegalArgumentException("Wrong input format for e-mail. Correct input example: \n"
                + "vasily.petrov@gmail.com");
        }

        if (!phoneMatcher.matches()){
            throw new IllegalArgumentException("Wrong input format for phone number. Correct input example: \n"
                + "+79215637722");
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}