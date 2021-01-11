import java.util.Scanner;

public class Main {

    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            handleCommand(input);
        }
    }

    private static void handleCommand(String input) {
        String textAfterCommand;
        int search;
        int index;
        if (input.equals("LIST")){
            todoList.getTodos();
        } else if (input.contains("ADD")) {
            textAfterCommand = input.substring(4);
            try {
                search = textAfterCommand.indexOf(" ");
                index = Integer.parseInt(textAfterCommand.substring(0, search));
                todoList.add(index, textAfterCommand.substring(search+1));
            }
            catch (Exception ex){
                todoList.add(textAfterCommand);
            }
        } else if (input.contains("DELETE")) {
            try {
                index = Integer.parseInt(input.substring(7));
                todoList.delete(index);
            }
            catch (Exception ex){
            }
        } else if (input.contains("EDIT")) {
            textAfterCommand = input.substring(5);
            try {
                search = textAfterCommand.indexOf(" ");
                index = Integer.parseInt(textAfterCommand.substring(0, search));
                todoList.edit(textAfterCommand.substring(search+1), index);
            }
            catch (Exception ex){
            }
        }
    }
}