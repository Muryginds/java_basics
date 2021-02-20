public class TopManager implements Employee {

  private static final int FIXED_SALARY = 60000;
  private Company company;

  public TopManager(Company company) {
    this.company = company;
  }

  @Override
  public int getMonthSalary() {
    return FIXED_SALARY + generateBonus();
  }

  private int generateBonus() {
    if (company.getIncome() > 10000000) {
      return (int)(1.5 * FIXED_SALARY);
    }
    return 0;
  }
}
