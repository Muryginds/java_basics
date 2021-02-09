public class CardAccount extends BankAccount {

  private static final double COMMISSION_RATE = 0.01D;

  @Override
  public void take(double amountToTake) {
    double totalWithdraw = amountToTake + amountToTake * COMMISSION_RATE;
    double moneyAmount = getAmount();
    if (moneyAmount >= totalWithdraw && amountToTake > 0) {
      moneyAmount -= totalWithdraw;
    }
  }
}