import java.lang.reflect.Array;

public class Alphabet {

  public static void main(String[] args) {
    String englishAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String russianAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    System.out.println(englishAlphabet);
    getCodeSymbolAndPrint(englishAlphabet);

    System.out.println(russianAlphabet);
    getCodeSymbolAndPrint(russianAlphabet);
  }

  private static void getCodeSymbolAndPrint(String input) {
    for ( int i = 0; i < input.length(); i++){
      char symbol = input.charAt(i);
      System.out.println(symbol + " - " + (int) symbol);
    }
  }
}
