public class Main {

  public static void main(String[] args) {
    Container container = new Container();
    container.count += 7843;

    int sum = sumDigits(7843);

    System.out.println(sum);
  }

  public static int sumDigits(Integer number) {

    int result = 0;

    if (number == null) {
      result = -1;
    } else {
      String stringNumber = number.toString();
      for (int i = 0; i < stringNumber.length(); i++) {
        result = result + Character.getNumericValue(stringNumber.charAt(i));
      }
    }
    return result;
  }
}
