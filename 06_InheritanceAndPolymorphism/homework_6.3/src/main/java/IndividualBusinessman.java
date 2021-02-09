public class IndividualBusinessman extends Client {

  public static final double COMMISSION_FOR_WITHDRAWING = 0.01;
  public static final double COMMISSION_FOR_DEPOSITING_STANDARD = 0.01;
  public static final double COMMISSION_FOR_DEPOSITING_LOWERED = 0.005;

  @Override
  public void take(double amountToTake) {
    double moneyAmount = getAmount();
    double amountToTakeWithCommission = amountToTake * (1 + COMMISSION_FOR_WITHDRAWING);
    if (amountToTakeWithCommission <= moneyAmount) {
      super.take(amountToTakeWithCommission);
    }
  }

  @Override
  public void put(double amountToPut) {
    double moneyAmount = getAmount();
    if (amountToPut >= 1000) {
      super.put(amountToPut * (1 - COMMISSION_FOR_DEPOSITING_LOWERED));
    } else if (amountToPut > 0) {
      super.put(amountToPut * (1 - COMMISSION_FOR_DEPOSITING_STANDARD));
    }
  }
}