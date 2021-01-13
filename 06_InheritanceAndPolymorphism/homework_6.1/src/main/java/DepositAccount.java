import java.time.LocalDate;

public class DepositAccount extends BankAccount {

  private static LocalDate lastIncome = LocalDate.now();

  public void take(double amountToTake) {
    if (moneyAmount >= amountToTake && amountToTake > 0 && !lastIncome.isAfter(LocalDate.now().minusMonths(1L))) {
      moneyAmount -= amountToTake;
      lastIncome = LocalDate.now();
    }
  }
}
