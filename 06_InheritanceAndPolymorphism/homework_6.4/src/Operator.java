public class Operator implements Employee{

  private static final int FIXED_SALARY = 30000;

  @Override
  public int getMonthSalary() {
    return FIXED_SALARY;
  }
}
