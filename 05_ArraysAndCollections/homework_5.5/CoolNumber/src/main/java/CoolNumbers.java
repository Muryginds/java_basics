import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class CoolNumbers {

    public static StringBuilder stringBuilder = new StringBuilder();
    public static final String ALLOWED_LETTERS = "АВЕКМНОРСТУХ";
    public static final int REGION_MAX = 199;
    public static final int CARS_AMOUNT = 2000000;

    public static List<String> generateCoolNumbers() {

        List<String> carNumbers = new ArrayList<>();

        for (int i = 0; i < CARS_AMOUNT; i++) {
            carNumbers.add(generateNumber());
        }

        return carNumbers;
    }

    private static String generateNumber() {
        stringBuilder.setLength(0);
        for (int i = 0; i < 7; i++){
            switch (i){
                case 1:
                case 2:
                case 3:
                    stringBuilder.append(generateDigit());
                    break;
                case 0:
                case 4:
                case 5:
                    stringBuilder.append(generateLetter());
                    break;
                case 6:
                    stringBuilder.append(generateRegion());
                    break;
            }
        }
        return stringBuilder.toString();
    }

    private static String generateRegion() {
        String result = "" + (int)(Math.random()*(REGION_MAX - 1) + 1);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }

    private static int generateDigit() {
        return (int)(Math.random()*9);
    }

    private static Character generateLetter() {
        return ALLOWED_LETTERS.charAt((int)(Math.random()*(ALLOWED_LETTERS.length()-1)));
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        boolean searchIsSuccessful = false;
        for(String element : list){
           if (element.equals(number)){
               searchIsSuccessful = true;
           }
        }
        return searchIsSuccessful;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
       return Collections.binarySearch(sortedList, number) >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
