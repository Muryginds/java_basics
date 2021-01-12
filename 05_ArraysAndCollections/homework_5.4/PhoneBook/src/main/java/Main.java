import java.util.Set;

public class Main {

    private final static String WRONG_ANSWER = "Неверный формат ввода";
    private final static String COMMAND_LIST = "LIST";
    private static boolean isName;
    private static boolean isPhoneNumber;

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        for (; ; ) {
            System.out.println("Введите номер, имя или команду:");
            String userInput = UserInput.getLine();
            isName = UserInput.isName(userInput);
            isPhoneNumber = UserInput.isPhoneNumber(userInput);
            if (userInput.equals(COMMAND_LIST)) {
                printListOfContacts(phoneBook.getAllContacts());
            } else if (isName) {
                Set<String> result = phoneBook.getPhonesByName(userInput);
                if (result.isEmpty()){
                    addNewContact(userInput, phoneBook);
                } else {
                    printListOfContacts(result);
                }

            } else if (isPhoneNumber) {
                String result = phoneBook.getNameByPhone(userInput);
                if (result.isEmpty()){
                    addNewContact(userInput, phoneBook);
                } else {
                    System.out.println(phoneBook.getNameByPhone(userInput));
                }
            } else {
                System.out.println(WRONG_ANSWER);
            }
        }
    }

    private static void addNewContact(String input, PhoneBook phoneBook) {
        String message = "";
        if (isName){
            message = "Такого имени нет в телефонной книге.\n"
                + "Введите номер телефона для абонента \"";
        } else {
            message = "Такого номера нет в телефонной книге.\n"
                + "Введите имя абонента для номера \"";
        }
        System.out.println(message + input + "\":");

        boolean inputNotComplite = true;
        while (inputNotComplite){
            String newInput = UserInput.getLine();
            inputNotComplite = !UserInput.isName(newInput) && !UserInput.isPhoneNumber(newInput);

            if (isName & !inputNotComplite){
                phoneBook.addContact(newInput, input);
            } else if (isPhoneNumber & !inputNotComplite){
                phoneBook.addContact(input, newInput);
            } else {
                System.out.println(WRONG_ANSWER + ". Попробуйте ещё раз:");
            }
        }

        System.out.println("Контакт сохранен!");
    }

    private static void printListOfContacts(Set<String> contacts) {
        for (String contact : contacts){
            System.out.println(contact);
        }
    }
}