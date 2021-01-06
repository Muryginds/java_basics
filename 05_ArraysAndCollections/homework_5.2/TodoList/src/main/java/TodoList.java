import java.util.ArrayList;

public class TodoList {

    public ArrayList<String> ARRAY_LIST = new ArrayList<>();

    public void add(String todo) {
        ARRAY_LIST.add(todo);
        System.out.println("Добавлено дело \"" + todo +"\"");
    }

    public void add(int index, String todo) {
        if (checkIndexIsValid(index)){
            ARRAY_LIST.add(index, todo);
        } else {
            ARRAY_LIST.add(todo);
        }
    }

    public void edit(String todo, int index) {
        if (checkIndexIsValid(index)){
            String temp = ARRAY_LIST.get(index);
            ARRAY_LIST.set(index, todo);
            System.out.println("Дело \"" + temp + "\" заменено на \"" + todo + "\"");
        }
    }

    public void delete(int index) {
        if (checkIndexIsValid(index)){
            ARRAY_LIST.remove(index);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        return ARRAY_LIST;
    }

    private boolean checkIndexIsValid(int index) {
        return index >= 0 && index < ARRAY_LIST.size();
    }
}