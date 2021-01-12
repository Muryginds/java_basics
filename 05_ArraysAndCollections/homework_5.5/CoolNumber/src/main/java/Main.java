import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        List<String> generatedNumbers = CoolNumbers.generateCoolNumbers();
        Collections.sort(generatedNumbers);
        String searchNumber = generatedNumbers.get(generatedNumbers.size()-1);
        StringBuilder result = new StringBuilder();
        boolean search = false;

        HashSet hashSet = new HashSet<String>(generatedNumbers);
        TreeSet treeSet = new TreeSet<String>(generatedNumbers);

        for (int i = 0; i < 4; i++) {
            long start = System.nanoTime();
            switch (i){
                case 0:
                    search = CoolNumbers.bruteForceSearchInList(generatedNumbers, searchNumber);
                    result.append("Поиск перебором");
                    break;
                case 1:
                    search = CoolNumbers.binarySearchInList(generatedNumbers, searchNumber);
                    result.append("Бинарный поиск");
                    break;
                case 2:
                    search = CoolNumbers.searchInHashSet(hashSet, searchNumber);
                    result.append("Поиск в HashSet");
                    break;
                case 3:
                    search = CoolNumbers.searchInTreeSet(treeSet, searchNumber);
                    result.append("Поиск в TreeSet");
                    break;
            }
            long end = System.nanoTime();
            result.append(": номер "+ (search? "найден" : "не найден")
                + ", поиск занял " + (end-start) + "нс\n");
        }

        System.out.println(result.toString());
    }
}
