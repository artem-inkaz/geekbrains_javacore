package Lessons5;

public class Cat extends Animal{
    static long counter;
    Long id;
    int barrier; // длина препятствия

    public Cat(String name, String color, String breed) {
        super(name, color, breed);
        this.id = ++counter;
    }

    @Override // проверка на переопределение метода
    public void run(){
        System.out.println(name + " Это Кошка любит бегать");
    }

    public void run(int length){
        System.out.println(name + " любит бегать и может пробежать не более " + length+ " метров");
    }

    @Override // проверка на переопределение метода
    public void swim(){
        System.out.println(name + " Это Кошка не любит и не может плавать/плыть");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
