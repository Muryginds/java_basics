import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);
        for (Employee person : staff) {
            System.out.println(person);
        };
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        staff.sort((o1, o2) -> {
            int result = o1.getSalary().compareTo(o2.getSalary());
            if (result == 0) {
                result = o1.getName().compareTo(o2.getName());
            }
            return result;
        });
    }
}