package Lessons11;

import java.util.ArrayList;
import java.util.List;

public class BoxFruitsArray<T extends Fruit> {
  private List<T> objectFruit;

  public BoxFruitsArray() {
    objectFruit = new ArrayList<>();
  }

  public void add(T t) {
    objectFruit.add(t);
  }

  public void addAll(List<T> list) {
    objectFruit.addAll(list);
  }

  public void addAllWildcards(List<? extends T> list) {
    objectFruit.addAll(list);
  }

  public T get(int index) {
    return objectFruit.get(index);
  }

  public List<T> getObjectFruit() {
    return objectFruit;
  }

  public void setObjectFruit(List<T> objectFruit) {
    this.objectFruit = objectFruit;
  }

  // Вычисляем вес коробки
  public double getWeight() {
    float sum = 0f;
    for (Fruit n : objectFruit) {
      sum +=n.weight;
    }
    return sum;
  }

  // Сравнение коробок
  public boolean compare(BoxFruitsArray<?> other) {
    return Math.abs(getWeight() - other.getWeight()) < 0.0001;
  }

  // пересыпать в коробки
  public void toEmpty() {

  }

  @Override
  public String toString() {
    return "BoxFruitsArray{" +
            "objectFruit=" + objectFruit +
            '}';
  }
}
