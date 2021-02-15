package Lessons5;

public class Dog extends Animal {
    static long counter;
    Long id;
      int barrier; // длина препятствия

    public Dog(String name, String color, String breed) {
        super(name, color, breed);
        this.id = ++counter;
    }

    @Override // проверка на переопределение метода
    public void run(){
        System.out.println(name + " Собака любит бегать");
    }

    public void run(int length){
        System.out.println(name + " Это Собака любит бегать и может пробежать больше " + length+ " метров");
    }


    @Override // проверка на переопределение метода
    public void swim(){
        System.out.println(name + " любит плавать/плыть");
    }

    public void swim(int barrier){
        System.out.println(name + " Это Собака любит плавать/плыть и может проплыть чуть больше "+ barrier+ " метров");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
