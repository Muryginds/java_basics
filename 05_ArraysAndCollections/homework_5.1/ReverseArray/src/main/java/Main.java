public class Main {

    public static final String LINE = "Каждый охотник желает знать, где сидит фазан";
    public static void main(String[] args) {

        String[] testArray = LINE.split(",?\\s+");
        testArray = ReverseArray.reverse(testArray);
        for (String element : testArray) {
            System.out.println(element);
        }
    }
}