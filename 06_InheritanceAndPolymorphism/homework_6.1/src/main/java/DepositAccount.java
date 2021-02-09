import java.time.LocalDate;

public class DepositAccount extends BankAccount {

  private static LocalDate lastIncome;

  @Override
  public void take(double amountToTake) {
    double moneyAmount = getAmount();
    if (moneyAmount >= amountToTake && amountToTake > 0 && !lastIncome.isAfter(LocalDate.now().minusMonths(1L))) {
      moneyAmount -= amountToTake;
      lastIncome = LocalDate.now();
    }
  }
}
