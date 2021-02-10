public class IndividualBusinessman extends Client {

  public static final double COMMISSION_FOR_WITHDRAWING = 0.01;
  public static final double COMMISSION_FOR_DEPOSITING_STANDARD = 0.01;
  public static final double COMMISSION_FOR_DEPOSITING_LOWERED = 0.005;

  @Override
  public void take(double amountToTake) {
    double moneyAmount = getAmount();
    double amountToTakeWithCommission = amountToTake * (1 + COMMISSION_FOR_WITHDRAWING);
    if (amountToTakeWithCommission <= moneyAmount) {
      moneyAmount -= amountToTakeWithCommission;
      setMoneyAmount(moneyAmount);
    }
  }

  @Override
  public void put(double amountToPut) {
    double moneyAmount = getAmount();
    if (amountToPut >= 1000) {
      moneyAmount += amountToPut * (1 - COMMISSION_FOR_DEPOSITING_LOWERED);
      setMoneyAmount(moneyAmount);
    } else if (amountToPut > 0) {
      moneyAmount += amountToPut * (1 - COMMISSION_FOR_DEPOSITING_STANDARD);
      setMoneyAmount(moneyAmount);
    }
  }
}