public class Manager implements Employee{

  private static final int FIXED_SALARY = 55000;
  private final int MONEY_GAINED_FROM_SALES;

  public Manager() {
    this.MONEY_GAINED_FROM_SALES = (int)(0.05 * (115000 + 25000 * Math.random()));
  }

  @Override
  public int getMonthSalary() {
    return FIXED_SALARY + MONEY_GAINED_FROM_SALES;
  }
}