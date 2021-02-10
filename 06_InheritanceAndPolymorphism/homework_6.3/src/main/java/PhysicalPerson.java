public class PhysicalPerson extends Client {

  @Override
  public void put(double amountToPut) {
    double moneyAmount = getAmount();
    if (amountToPut > 0) {
      moneyAmount += amountToPut;
      setMoneyAmount(moneyAmount);
    }
  }

  @Override
  public void take(double amountToTake) {
    double moneyAmount = getAmount();
    if (amountToTake <= moneyAmount) {
      moneyAmount -= amountToTake;
      setMoneyAmount(moneyAmount);
    }
  }
}
