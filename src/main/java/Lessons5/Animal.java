package Lessons5;

public abstract class Animal {
    //private видимость только внутри класса
    //protected видимость только внутри package Lessons5
    String name;
    String color;
    String breed; // порода
  //  int barrier; // длина препятствия


    public Animal() {
    }

    public Animal(String name, String color, String breed) {
        this.name = name;
        this.color = color;
        this.breed = breed;
    //    this.barrier = barrier;
    }

    public abstract void swim();
    public abstract void run();

    public void jump(){
        System.out.println("Животное подпрыгнуло");
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setBarrier(int barrier) {
//        this.barrier = barrier;
//        System.out.println("Животное может преодолеть дистанцию протяженностью");
//    }
}
