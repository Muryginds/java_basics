public abstract class Client {

    private double moneyAmount;

    protected double getAmount() {
        return moneyAmount;
    }

    protected void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    abstract void put(double amountToPut);

    abstract void take(double amountToTake);
}