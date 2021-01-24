package Lessons6;

public class Cat {
    private String name;
    private int appetite;
    protected boolean full = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;

    }

    public void eat(Plate plate){
        plate.decreasedFood(appetite);
       if  (plate.food >=0) this.full= true;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", full=" + full +
                '}';
    }
}
