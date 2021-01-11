import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    public static EmailList emailList = new EmailList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            if (input.equals("LIST")){
                List<String> list = emailList.getSortedEmails();
                for (String mail : list){
                    System.out.println(mail);
                }
            } else if (input.contains("ADD")) {
                try {
                    String email = input.substring(4);
                    if (!emailList.checkEmailFormat(email)){
                        System.out.println(WRONG_EMAIL_ANSWER);
                    } else {
                        emailList.add(email);
                    };
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
