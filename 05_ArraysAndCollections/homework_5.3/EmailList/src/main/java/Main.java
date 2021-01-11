public class Main {

    private final static String WRONG_EMAIL_ANSWER = "Неверный формат email";
    private final static String WRONG_COMMAND = "Неверная команда";
    private final static String COMMAND_ADD = "ADD";
    private final static String COMMAND_LIST = "LIST";

    public static void main(String[] args) {

        EmailList emailList = new EmailList();
        for (; ; ) {
            String userInput = UserInput.getLine();
            String email = userInput.replaceFirst(COMMAND_ADD, "").trim();
            if (userInput.startsWith(COMMAND_ADD)) {
                if (emailList.checkEmailFormat(email)){         //заглушка для автотестов
                    emailList.add(email);
                } else {
                    System.out.println(WRONG_EMAIL_ANSWER);
                }
            } else if (userInput.equals(COMMAND_LIST)) {
                emailList.printList();
            } else {
                System.out.println(WRONG_COMMAND);
            }
        }
    }
}
