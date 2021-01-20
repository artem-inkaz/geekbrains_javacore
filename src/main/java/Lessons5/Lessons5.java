package Lessons5;

public class Lessons5 {
    public static void main(String[] args) {

//        name, color, breed, barrier;
        Cat cat = new Cat("Marfa","Yellow", "Bobtail");

        Dog dog = new Dog("Archi","Black", "Doberman");

        Animal cat1 = new Cat("Izolda","White", "Homless");

        Animal dog1 = new Dog("Baron","Grey", "Layka");

        Animal[] animals = new Animal[2];

        Animal[] animals1 = {cat, dog};

//        for (Animal animal : animals1){
//            animal.jump();
//            animal.run();
//        }
        for (int i = 0; i<animals1.length; i++){
            animals1[i].run();
            animals1[i].jump();

            if (animals1[i] instanceof Cat) ((Cat) animals1[i]).swim();
            if (animals1[i] instanceof Dog) ((Dog) animals1[i]).swim();
        }

        cat.swim();
        ((Cat) cat1).run(200);

        ((Dog) dog1).swim(10);
        ((Dog) dog1).run(500);

        System.out.println(cat1.toString());
//        System.out.println("Мы создали "+ ((Cat) cat1).id+ " Кошек");
        System.out.println("Мы создали "+ Cat.counter+ " Кошек");
        System.out.println(dog1.toString());
//        System.out.println("Мы создали "+ ((Dog) dog1).id+ " Собак");
        System.out.println("Мы создали "+ Dog.counter+ " Собак");
    }
}
