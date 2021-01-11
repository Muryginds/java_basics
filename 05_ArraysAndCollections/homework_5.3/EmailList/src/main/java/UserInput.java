import java.util.Scanner;

public class UserInput {

  public static Scanner scanner = new Scanner(System.in);

  public static String getLine() {
    return scanner.nextLine();
  }
}