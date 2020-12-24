import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число ящиков: ");
        String boxes = scanner.nextLine();
        calculateAndPrint(boxes);
    }

    private static void calculateAndPrint(String boxes) {
        int cargoMaxCapacity = 12;
        int containerMaxCapacity = 27;
        int boxesTotal = Integer.parseInt(boxes);
        int cargoTotal = boxesTotal / (containerMaxCapacity * cargoMaxCapacity);
        int boxesLeftout = boxesTotal % containerMaxCapacity;
        int containersLeftout = boxesLeftout / cargoMaxCapacity;

        // выводим полностью заполненные грузовики
        int i = 0;
        if (boxesTotal > 0){
            for (i = 1; cargoTotal >= i; i++) {
                System.out.println("Грузовик: " + i);
                for (int j = 1; cargoMaxCapacity >= j; j++) {
                    System.out.println("\tКонтейнер: " + j);
                    for (int l = 1; containerMaxCapacity  >= l; l++) {
                        System.out.println("\t\tЯщик: " + l);
                    }
                }
            }
        }

        // выводим остатки ящиков
        if (boxesLeftout > 0) {
            System.out.println("Грузовик: " + i);
            for (int j = 1; containersLeftout + 1 >= j; j++) {
                System.out.println("\tКонтейнер: " + j);
                for (int l = 1; boxesLeftout >= l; l++) {
                    System.out.println("\t\tЯщик: " + l);
                }
            }
        }

       int containerCount = 0;
        if (boxesTotal != 0) {
            containerCount = Math.addExact(boxesTotal / containerMaxCapacity, 1);
        }

        System.out.println("Необходимо: ");
        System.out.println("грузовиков - " + i + " шт.");
        System.out.println("контейнеров - " +  containerCount + " шт.");
    }

}
