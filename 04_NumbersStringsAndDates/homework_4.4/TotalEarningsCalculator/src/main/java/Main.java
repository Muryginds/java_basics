public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

    String lastPart = text.substring(text.lastIndexOf(",")+4, text.lastIndexOf(" руб"));

    text = text.substring(0, text.lastIndexOf(","));
    String middlePart = text.substring(text.lastIndexOf(",")+2, text.lastIndexOf(" руб"));

    String firstPart = text.substring(0, text.indexOf(" руб"));

    System.out.println("Сумма заработка всех друзей: ");
    System.out.println(calculateProfit(firstPart) + calculateProfit(middlePart) + calculateProfit(lastPart));
  }

  private static int calculateProfit(String string) {
    String profit = string.substring(string.lastIndexOf(" "));
    return Integer.parseInt(profit.trim());
  }
}