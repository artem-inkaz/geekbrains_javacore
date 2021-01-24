package Lessons6;

public class Plate {
    protected int food;
//    protected int additionfood = 0;

    public void putFood(int amount) {
        this.food += amount;
        System.out.println("В миску сегодня положили " + food + " печенек");
    }

    public void putAdditionFood(int additionAmount) {
//        this.food +=this.additionfood;
        this.food += additionAmount;
        System.out.println("В миску сегодня добавили еще " + additionAmount + " печенек");
    }


    public void decreasedFood(int amount) {
        this.food -= amount;
//        if (food >=0) System.out.println("В миске уменьшилось еды и теперь " + food);

//        else System.out.println("В миске не осталос еды и теперь " + food);
    }

}
