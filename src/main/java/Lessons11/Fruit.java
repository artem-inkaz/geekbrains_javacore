package Lessons11;

public class Fruit {
    public float weight;
//    private String type;

    public Fruit(float weight) {
        this.weight = weight;
//        this.type = type;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                '}';
    }
}
