public class IndividualBusinessman extends Client {

  public static final double COMMISSION_FOR_WITHDRAWING = 0.01;
  public static final double COMMISSION_FOR_DEPOSITING_STANDART = 0.01;
  public static final double COMMISSION_FOR_DEPOSITING_LOWERED = 0.005;

  public void take(double amountToTake) {
    double moneyAmount = getAmount();
    double amountToTakeWithCommission = amountToTake * (1 + COMMISSION_FOR_WITHDRAWING);
    if (amountToTakeWithCommission <= moneyAmount) {
      moneyAmount -= amountToTakeWithCommission;
      setAmount(moneyAmount);
    }
  }

  public void put(double amountToPut) {
    double moneyAmount = getAmount();
    if (amountToPut >= 1000) {
      moneyAmount += amountToPut * (1 - COMMISSION_FOR_DEPOSITING_LOWERED);
    } else if (amountToPut > 0) {
      moneyAmount += amountToPut * (1 - COMMISSION_FOR_DEPOSITING_STANDART);
    }
    setAmount(moneyAmount);
  }
}