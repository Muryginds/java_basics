public class CardAccount extends BankAccount {

  private static final double COMMISSION_RATE = 0.01;

  public void take(double amountToTake) {
    double totalWithdraw = amountToTake + amountToTake * COMMISSION_RATE;
    if (moneyAmount >= totalWithdraw && amountToTake > 0) {
      moneyAmount -= totalWithdraw;
    }
  }
}