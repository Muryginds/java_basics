import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static final String CAR_NUMBER = "М690ОВ116";

    public static void main(String[] args) {
        List<String> generatedNumbers = CoolNumbers.generateCoolNumbers();
        StringBuilder result = CoolNumbers.STRING_RESULT;
        result.setLength(0);
        boolean search = false;
        String searchName = "";
        Collections.sort(generatedNumbers);
        HashSet hashSet = new HashSet<String>(generatedNumbers);
        TreeSet treeSet = new TreeSet<String>(generatedNumbers);

        for (int i = 0; i < 4; i++) {
            long start = System.nanoTime();
            switch (i){
                case 0:
                    search = CoolNumbers.bruteForceSearchInList(generatedNumbers, CAR_NUMBER);
                    searchName = "Поиск перебором";
                    break;
                case 1:
                    search = CoolNumbers.binarySearchInList(generatedNumbers, CAR_NUMBER);
                    searchName = "Бинарный поиск";
                    break;
                case 2:
                    search = CoolNumbers.searchInHashSet(hashSet, CAR_NUMBER);
                    searchName = "Поиск в HashSet";
                    break;
                case 3:
                    search = CoolNumbers.searchInTreeSet(treeSet, CAR_NUMBER);
                    searchName = "Поиск в TreeSet";
                    break;
            }
            long end = System.nanoTime();
            result.append(searchName + ": номер "+ (search? "найден" : "не найден")
                + ", поиск занял " + (end-start) + "нс\n");
        }

        System.out.println(result.toString());
    }
}
