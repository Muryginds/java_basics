public class Loader
{
    public static void main(String[] args)
    {
        Cat cat0 = new Cat();
        cat0.setColor(Color.BLACK);
        System.out.println("current weight of cat0: " + cat0.getWeight());
        System.out.println(cat0.getColor());
        cat0.feed(1.0);
        System.out.println(cat0.getStatus());

        Cat cat1 = new Cat();
        cat1.setColor(Color.WHITE);
        System.out.println("current weight of cat1: " + cat1.getWeight());
        System.out.println(cat1.getColor());
        cat1.feed(1.0);
        System.out.println(cat1.getStatus());

        Cat cat2 = new Cat();
        cat2.setColor(Color.BROWN);
        System.out.println("current weight of cat2: " + cat2.getWeight());
        System.out.println(cat2.getColor());
        cat2.feed(6000.0);
        System.out.println(cat2.getStatus());

        Cat cat3 = new Cat();
        cat3.setColor(Color.GREY);
        System.out.println("current weight of cat3: " + cat3.getWeight());
        System.out.println(cat3.getColor());
        cat3.feed(1.0);

        //Мяукаем до истощения
        while (cat3.getStatus() != "Dead") {
            cat3.meow();
        }
        System.out.println(cat3.getStatus());

        Cat cat4 = new Cat();
        cat4.setColor(Color.ORANGE);
        System.out.println("current weight of cat4: " + cat4.getWeight());
        System.out.println(cat4.getColor());
        cat4.feed(1.0);

        //Взрываем кота
        while (cat4.getStatus() != "Exploded") {
            cat4.feed(1.0);
        }
        System.out.println(cat4.getStatus());

        /* System.out.println("Начальный вес кота: " + cat2.getWeight());

        cat2.pee();
        cat2.feed(100.0);
        cat2.pee();
        cat2.feed(150.0);
        cat2.pee();
        cat2.drink(50.0);

        double WeightOfEatenFood = cat2.getWeightOfEatenFood();

        System.out.println("Текущий вес кота: " + cat2.getWeight());
        System.out.println("Кот съел: "+ WeightOfEatenFood);

         */
        System.out.println("Ammount of living cats:" + Cat.getCount());

        Cat cat5 = getKitten();
        System.out.println(cat5.getWeight());
        cat5.setColor(Color.BLACK);
        System.out.println(cat5.getColor());

        Cat cat6 = getKitten();
        System.out.println(cat6.getWeight());
        cat6.setColor(Color.BROWN);
        System.out.println(cat6.getColor());

        Cat cat7 = getKitten();
        System.out.println(cat7.getWeight());
        cat7.setColor(Color.WHITE);
        System.out.println(cat7.getColor());


        Cat cat8 = copyCat(cat7);
        System.out.println(cat7.getWeight() +" "+ cat7.getColor());
        System.out.println(cat8.getWeight() +" "+ cat8.getColor());

        //System.out.println(Cat.getCount());
    }

    private static Cat getKitten(){
        Cat cat = new Cat(1100);
        return cat;
    }

    private static Cat copyCat(Cat cat){
        Cat copy = new Cat(cat.getWeight(),cat.getColor());
        return copy;
    }

}