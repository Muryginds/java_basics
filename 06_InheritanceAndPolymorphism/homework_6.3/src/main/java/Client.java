public abstract class Client {

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
        if (amountToTake <= moneyAmount) {
            moneyAmount -= amountToTake;
        }
    }
}