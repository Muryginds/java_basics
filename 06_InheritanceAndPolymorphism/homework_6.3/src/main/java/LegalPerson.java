public class LegalPerson extends Client {

  public static final double COMMISSION_FOR_WITHDRAWING = 0.01;

  @Override
  public void take(double amountToTake) {
    double moneyAmount = getAmount();
    double amountToTakeWithCommission = amountToTake * (1 + COMMISSION_FOR_WITHDRAWING);
    if (amountToTakeWithCommission <= moneyAmount) {
      super.take(amountToTakeWithCommission);
    }
  }
}
