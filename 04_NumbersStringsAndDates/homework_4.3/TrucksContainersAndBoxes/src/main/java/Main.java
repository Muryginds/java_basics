import java.util.Scanner;

public class Main {

    static final int BOX_IN_CONTAINER = 27;
    static final int CONTAINER_IN_TRUCK = 12;
    static final int BOX_IN_TRUCK = BOX_IN_CONTAINER * CONTAINER_IN_TRUCK;
    static final String EXIT_CODE = "exit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для выхода из программы введите слово: exit");
        System.out.print("Введите число ящиков: ");
        String boxes = scanner.nextLine();

        if (boxes.equals(EXIT_CODE)) {
            return;
        }
        calculateAndPrint(boxes);
    }

    private static void calculateAndPrint(String boxes) {

        int boxesTotal = Integer.parseInt(boxes);
        int trucksCount = 0;
        int containersCount = 0;

        for (int i = 0; i < boxesTotal;){
            if (i % BOX_IN_TRUCK == 0) {
                System.out.println("Грузовик: " + ++trucksCount);
            }
            if (i % BOX_IN_CONTAINER == 0) {
                System.out.println("\tКонтейнер: " + ++containersCount);
            }
            System.out.println("\t\tЯщик: " + ++i);
        }


        System.out.println("Необходимо: ");
        System.out.println("грузовиков - " + trucksCount + " шт.");
        System.out.println("контейнеров - " +  containersCount + " шт.");
    }

}
