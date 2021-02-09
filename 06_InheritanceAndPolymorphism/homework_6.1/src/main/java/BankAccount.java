public class BankAccount {

  private double moneyAmount = 0D;

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
    if(amount > 0 && amount > moneyAmount){
      receiver.put(amount);
      moneyAmount -= amount;
      transferSuccess = true;
    }
    return transferSuccess;
  }
}


