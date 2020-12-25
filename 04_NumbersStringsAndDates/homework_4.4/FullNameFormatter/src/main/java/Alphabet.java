import java.lang.reflect.Array;

public class Alphabet {

  private static final String ENGLISH_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String RUSSIAN_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

  public static void main(String[] args) {

    System.out.println(ENGLISH_ALPHABET);
    getCodeSymbolAndPrint(ENGLISH_ALPHABET);

    System.out.println(RUSSIAN_ALPHABET);
    getCodeSymbolAndPrint(RUSSIAN_ALPHABET);
  }

  private static void getCodeSymbolAndPrint(String input) {
    for ( int i = 0; i < input.length(); i++){
      char symbol = input.charAt(i);
      System.out.println(symbol + " - " + (int) symbol);
    }
  }
}
