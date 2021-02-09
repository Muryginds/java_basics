import java.time.LocalDate;

public class DepositAccount extends BankAccount {

  private static LocalDate lastIncome;

  @Override
  public void put(double amountToPut) {
    if (amountToPut > 0) {
      super.put(amountToPut);
      lastIncome = LocalDate.now();
    }
  }

  @Override
  public void take(double amountToTake) {
    double moneyAmount = getAmount();
    if (moneyAmount >= amountToTake && amountToTake > 0 && !lastIncome.isAfter(LocalDate.now().minusMonths(1L))) {
      super.take(amountToTake);
      lastIncome = LocalDate.now();
    }
  }
}