import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Company company = new Company(150000000);
    ArrayList<Employee> employees = new ArrayList<>();
    for (int i = 1; i < 180; i++) {
      employees.add(new Operator());
    }
    for (int i = 1; i < 80; i++) {
      employees.add(new Manager());
    }
    for (int i = 1; i < 10; i++) {
      employees.add(new TopManager(company));
    }
    company.hireAll(employees);
    printElementsOfList(company.getTopSalaryStaff(15));
    printElementsOfList(company.getLowestSalaryStaff(30));

    for (int i = employees.size()-1; i >= 0 ; i--) {
      if (i % 2 == 0) {
        company.fire(employees.get(i));
      }
    }
    printElementsOfList(company.getTopSalaryStaff(15));
    printElementsOfList(company.getLowestSalaryStaff(30));
  }

  private static void printElementsOfList(List<Employee> topSalaryStaff) {
    for (Employee employee : topSalaryStaff) {
      System.out.println(employee.getMonthSalary());
    }
    System.out.println("---------------");
  }
}
