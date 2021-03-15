import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Movements {
    private static final Pattern TRANSACTION_PATTERN  = Pattern.compile
        ("[^,]+[^\\/]+?([\\/|\\\\].+)\\s{9,}.+[\\s]{3,}.+?,\"?([0-9,]+)\"?,\"?([0-9,]+)\"?");
    private static final String replaceString = "[/>\\\\]";
    private static List<Transaction> transactionsList = new ArrayList<>();

    public Movements(String pathMovementsCsv) {
        try {
            transactionsList = Files.lines(Path.of(pathMovementsCsv))
                .flatMap(s -> TRANSACTION_PATTERN.matcher(s).results().map(matchResult ->
                    new Transaction(matchResult.group(1).trim().replaceAll(replaceString, ""),
                        Double.parseDouble(matchResult.group(2).replace(",",".")),
                        Double.parseDouble(matchResult.group(3).replace(",",".")))))
                .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getExpenseSum() {
        return transactionsList.stream().mapToDouble(Transaction::getCredit).sum();
    }

    public double getIncomeSum() {
        return transactionsList.stream().mapToDouble(Transaction::getDebit).sum();
    }

    public void printMovements() {
        System.out.println("Суммы расходов по организациям:");
        transactionsList.stream()
            .filter(t -> t.getDebit() == 0)
            .collect(Collectors.groupingBy(Transaction::getOrganizationName, Collectors.summingDouble(
                Transaction::getCredit))).forEach((s, aDouble) -> System.out.println(s + "\t\t\t" + aDouble + " руб."));
    }
}
