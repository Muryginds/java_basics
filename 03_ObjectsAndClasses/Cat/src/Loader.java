
public class Loader
{
    public static void main(String[] args)
    {
        Cat cat0 = new Cat();
        System.out.println("Текущий вес кота0: " + cat0.getWeight());

        Cat cat1 = new Cat();
        System.out.println("Текущий вес кота1: " + cat1.getWeight());

        Cat cat2 = new Cat();
        System.out.println("Текущий вес кота2: " + cat2.getWeight());

        Cat cat3 = new Cat();
        System.out.println("Текущий вес кота3: " + cat3.getWeight());

        Cat cat4 = new Cat();
        System.out.println("Текущий вес кота4: " + cat4.getWeight());

        //Мяукаем до истощения
        while (cat3.getStatus() != "Dead") {
            cat3.meow();
        }
        System.out.println(cat3.getStatus());

        //Взрываем кота
        while (cat4.getStatus() != "Exploded") {
            cat4.feed(1.0);
        }
        System.out.println(cat4.getStatus());
    }
}