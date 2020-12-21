
public class Cat
{
    public static int count = 0;
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double foodEaten;

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
    }

    public void meow()
    {
        weight = weight - 1;
        //System.out.println("Meow");
    }

    public void pee()
    {
        if (checkCatAlive()){
            weight = weight - 10;
            System.out.println("Cat peed..");
        }
        else{
            System.out.println("Cat is dead");
        }
    }

    public void feed(Double amount)
    {
        if (checkCatAlive()){
        weight = weight + amount;
        foodEaten = foodEaten + amount;
        }
        else{
           System.out.println("Cat is dead");
        }
    }

    public void drink(Double amount)
    {
        if (checkCatAlive()){
            weight = weight + amount;
        }
        else{
            System.out.println("Cat is dead");
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

    public boolean checkCatAlive() {
        if(weight < minWeight) {
            return false;
        }
        else if(weight > maxWeight) {
            return false;
        }
        else if(weight > originWeight) {
            return true;
        }
        else {
            return true;
        }
    }
}
