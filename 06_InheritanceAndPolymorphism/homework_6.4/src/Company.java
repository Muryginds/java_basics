import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {
  private ArrayList<Employee> employeeList = new ArrayList<>();
  private long income;

  public Company(long income){
    this.income = income;
  }

  public List<Employee> getTopSalaryStaff(int count) {
    List<Employee> result = new ArrayList<>();
    if (count > 0) {
      employeeList.sort(new Comparator<Employee>() {
        public int compare(Employee o1, Employee o2) {
          return -Integer.compare(o1.getMonthSalary(), o2.getMonthSalary());
        }
      });

      if (count > employeeList.size()) {
        count = employeeList.size();
      }

      result =  employeeList.subList(0, count);
    }
    return result;
  }

  public List<Employee> getLowestSalaryStaff(int count) {
    List<Employee> result = new ArrayList<>();
    if (count > 0) {
      employeeList.sort(new Comparator<Employee>() {
        public int compare(Employee o1, Employee o2) {
          return Integer.compare(o1.getMonthSalary(), o2.getMonthSalary());
        }
      });

      if (count > employeeList.size()) {
        count = employeeList.size();
      }

      result =  employeeList.subList(0, count);
    }
    return result;
  }

  public void hire(Employee employee){
    employeeList.add(employee);
  }

  public void hireAll(ArrayList<Employee> employeeListToHire){
    employeeList.addAll(employeeListToHire);
  }

  public void fire(Employee employee){
    employeeList.remove(employee);
  }

  public long getIncome() {
    return income;
  }
}
