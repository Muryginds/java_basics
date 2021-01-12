import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<String> result;
        PhoneBook phoneBook = new PhoneBook();
        for (; ; ) {
            System.out.println("Введите номер, имя или команду:");
            String userInput = UserInput.getLine();
            ActionType action = UserInput.getAction(userInput);

            switch (action) {
                case PRINT_ALL:
                    printListOfContacts(phoneBook.getAllContacts());
                    break;
                case SEARCH_BY_NAME:
                    result = phoneBook.getPhonesByName(userInput);
                    if (result.isEmpty()){
                        addNewContact(userInput, phoneBook, ActionType.SEARCH_BY_NAME);
                    } else {
                        printListOfContacts(result);
                    }
                    break;
                case SEARCH_BY_PHONE_NUMBER:
                    result = phoneBook.getPhonesByName(userInput);
                    if (result.isEmpty()){
                        addNewContact(userInput, phoneBook, ActionType.SEARCH_BY_PHONE_NUMBER);
                    } else {
                        printListOfContacts(result);
                    }
                    break;
                default:
                    System.out.println(UserInput.WRONG_ANSWER);
                    break;
            }
        }
    }

    private static void addNewContact(String input, PhoneBook phoneBook, ActionType action) {
        StringBuilder message = new StringBuilder();
        message.append("Такого ");
        switch (action){
            case SEARCH_BY_NAME:
                message.append("имени ");
                break;
            case SEARCH_BY_PHONE_NUMBER:
                message.append("номера ");
                break;
        }
        message.append("нет в телефонной книге.\nВведите ");
        switch (action){
            case SEARCH_BY_NAME:
                message.append("номер телефона для абонента ");
                break;
            case SEARCH_BY_PHONE_NUMBER:
                message.append("имя абонента для номера ");
                break;
        }
        message.append("\"" + input + "\":");

        System.out.println(message);

        boolean inputComplite = false;
        while (!inputComplite){

            String newInput = UserInput.getLine();
            inputComplite = newInput.matches(PhoneBook.NAME_CHECK_REGEX) || newInput.matches(PhoneBook.PHONE_CHECK_REGEX);

            if (action == ActionType.SEARCH_BY_NAME & inputComplite){
                phoneBook.addContact(newInput, input);
            } else if (action == ActionType.SEARCH_BY_PHONE_NUMBER & inputComplite){
                phoneBook.addContact(input, newInput);
            } else {
                System.out.println(UserInput.WRONG_ANSWER + ". Попробуйте ещё раз:");
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