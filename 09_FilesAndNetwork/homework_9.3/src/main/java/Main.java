public class Main {
    private static final String PATH = "data/movementList.csv";
    public static void main(String[] args) {
        Movements movements = new Movements(PATH);
        System.out.println(movements.getExpenseSum() + " руб.");
        System.out.println(movements.getIncomeSum() + " руб.");
        System.out.println();
        movements.printMovements();
    }
}
