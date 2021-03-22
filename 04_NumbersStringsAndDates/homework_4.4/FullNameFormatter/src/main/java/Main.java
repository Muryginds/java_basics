import java.util.Scanner;

public class Main {

  private static final String NOT_FIO_MESSAGE = "Введенная строка не является ФИО";
  private static final String RUSSIAN_ALPHABET_WITH_EXRA_SYMBOLS = "- абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();

      if (input.equals("0")) {
        break;
      }

      if (!checkStringIsValid(input)){
        printWarning();
        break;
      }

      String name = "";
      String lastName = "";
      String fatherName = "";

      try {
        lastName = input.substring(0, input.indexOf(" "));
      } catch (Exception e){
        printWarning();
        break;
      }

      input = input.substring(lastName.length() + 1);

      try {
        name = input.substring(0,input.indexOf(" "));
      }
      catch (Exception e){
        printWarning();
        break;
      }

      fatherName = input.substring(name.length() + 1);

      if (fatherName.contains(" ")){
        printWarning();
        break;
      }

      System.out.println("Фамилия: " + lastName);
      System.out.println("Имя: " + name);
      System.out.println("Отчество: " + fatherName);
    }
  }

  private static void printWarning() {
    System.out.println(NOT_FIO_MESSAGE);
  }

  private static boolean checkStringIsValid(String input) {
    int i = 0;
    while (i < input.length()){
      char character = input.charAt(i);

      boolean result = RUSSIAN_ALPHABET_WITH_EXRA_SYMBOLS.contains(Character.toString(character));
      if (!result){
        return false;
      }
      i++;
    }
    return true;
  }
}