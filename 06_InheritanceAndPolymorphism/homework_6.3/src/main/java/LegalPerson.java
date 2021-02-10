public class LegalPerson extends Client {

  public static final double COMMISSION_FOR_WITHDRAWING = 0.01;

  @Override
  public void take(double amountToTake) {
    double moneyAmount = getAmount();
    double amountToTakeWithCommission = amountToTake * (1 + COMMISSION_FOR_WITHDRAWING);
    if (amountToTakeWithCommission <= moneyAmount) {
      moneyAmount -=  amountToTakeWithCommission;
      setMoneyAmount(moneyAmount);
    }
  }

  @Override
  public void put(double amountToPut) {
    double moneyAmount = getAmount();
    if (amountToPut > 0) {
      moneyAmount += amountToPut;
      setMoneyAmount(moneyAmount);
    }
  }
}
