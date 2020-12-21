
public class Cat
{
    public static int count = 0;
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double foodEaten;
    private boolean isAlive;

    public static int getCount(){
        return count;
    }

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        foodEaten = 0;
        count = count + 1;
        isAlive = true;
    }

    public void meow()
    {
        if (isAlive){
            weight = weight - 1;
            //System.out.println("Meow");
            if (!isWeightNormal()) {
                System.out.println("Cat is dead");
                count = count - 1;
                isAlive = isWeightNormal();
            }
        }

    }

    public void pee()
    {
        if (isAlive){
            weight = weight - 10;
            System.out.println("Cat peed..");
            if (!isWeightNormal()) {
                System.out.println("Cat is dead");
                count = count - 1;
                isAlive = isWeightNormal();
            }
        }
    }

    public void feed(Double amount)
    {
        if (isAlive){
            weight = weight + amount;
            foodEaten = foodEaten + amount;
            if (!isWeightNormal()) {
                System.out.println("Cat is dead");
                count = count - 1;
                isAlive = isWeightNormal();
            }
        }
    }

    public void drink(Double amount)
    {
        if (isAlive){
            weight = weight + amount;
            if (!isWeightNormal()) {
                System.out.println("Cat is dead");
                count = count - 1;
                isAlive = isWeightNormal();
            }
        }
    }

    public Double getWeight()
    {
        return weight;
    }

    public Double getWeightOfEatenFood()
    {
        return foodEaten;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    public boolean isWeightNormal() {
        return (weight > minWeight && weight < maxWeight);
    }
}
