import java.util.Scanner;

public class UserInput {

  public final static String WRONG_ANSWER = "Неверный формат ввода";
  private final static String COMMAND_LIST = "LIST";
  private static Scanner scanner = new Scanner(System.in);

  public static String getLine() {
   return scanner.nextLine();
  }

  public static ActionType getAction(String input) {
    ActionType action;
    if (input.equals(COMMAND_LIST)){
      action = ActionType.PRINT_ALL;
    } else if (input.matches(PhoneBook.NAME_CHECK_REGEX)) {
      action = ActionType.SEARCH_BY_NAME;
    } else if (input.matches(PhoneBook.PHONE_CHECK_REGEX)) {
      action = ActionType.SEARCH_BY_PHONE_NUMBER;
    } else {
      action = null;
    }
    return action;
  }
}
