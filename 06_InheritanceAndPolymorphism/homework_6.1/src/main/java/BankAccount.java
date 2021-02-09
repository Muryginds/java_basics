public class BankAccount {

  private double moneyAmount;

  public double getAmount() {
    return moneyAmount;
  }

  public void put(double amountToPut) {
    if (amountToPut > 0) {
      moneyAmount += amountToPut;
    }
  }

  public void take(double amountToTake) {
    if (moneyAmount >= amountToTake && amountToTake > 0) {
      moneyAmount -= amountToTake;
    }
  }

  private boolean send(BankAccount receiver, double amount) {
    boolean transferSuccess = false;
    if(amount > 0 && amount < moneyAmount){
      receiver.put(amount);
      this.take(amount);
      transferSuccess = true;
    }
    return transferSuccess;
  }
}
