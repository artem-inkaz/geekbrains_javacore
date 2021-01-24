package Lessons6;

import Lessons4.Student;

import java.util.Scanner;

public class Lessons6 {

    // Для ввода из консоли
    private static final Scanner SCANNER = new Scanner(System.in);

    // Запрашиваемый количество печенек в миске
    private static int countFood,addFood;

    //сытые коты
    private static int fullCat;

    //голодные коты
    private static int flag;


    public static void main(String[] args) {

        countFood();

        //5. Создание массива котов
        Cat[]  catsArray = new Cat[5];

        catsArray[0] = new Cat( "Barsik", 55);
        catsArray[1] = new Cat("Izolda",25);
        catsArray[2] = new Cat("Dymok", 33);
        catsArray[3] = new Cat("Beglyi", 41);
        catsArray[4] = new Cat("Marusya", 37);

        Plate plate = new Plate();
        plate.putFood(countFood);

        for (int i =0; i<catsArray.length; i++){

            catsArray[i].eat(plate);
            fullCat +=1;
            flag=1;
            if (catsArray[i].full == false) {
                if (fullCat > 1) fullCat -= 1;
                System.out.println("В миске не осталось еды! Нужно добавить!");
                System.out.println("Будем делать добавку?! Введите Y/N");
                System.out.println("Сытыми остаются всего " + fullCat + " кота");
                System.out.println("Голодными остаются всего " + (catsArray.length - fullCat) + " кота");
                playGame();
                if (flag == 0) {
                    System.out.println("Сытыми остаются всего " + fullCat + " кота");
                    System.out.println("Голодными остаются всего " + (catsArray.length - fullCat) + " кота");
                    break;
                } else {plate.putAdditionFood(addFood);
                catsArray[i].full = true;}
            }

        }

        System.out.println("Сытые коты сегодня:");
        for (int i = 0; i <catsArray.length; i++) {
           if (catsArray[i].full == true)
            System.out.println(catsArray[i].toString());
        }
        System.out.println("Голодные сегодня:");
        for (int i = 0; i <catsArray.length; i++) {
            if (catsArray[i].full == false)
                System.out.println(catsArray[i].toString());
            if (catsArray[i].full != false && (i == catsArray.length-1)) System.out.println("Голодных котов сегодня нет! Ура!!!");
        }

    }

    // Задаем количество еды в миске
    private static void countFood() {
        int x;
        System.out.print("Введите количество печенек в миске для кисок ->");
        x = SCANNER.nextInt();
        countFood = x;
    }

    // Предложить продолжить игру или закончить
    private static boolean playGame() {
        System.out.println("Wanna play again?");
        if (!SCANNER.next().equals("y")){
            SCANNER.close();
            flag = 0;
            return false;
        }
        additionFood();
        return true;
    }

    // Задаем добавку количество еды в миске
    private static void additionFood() {
        int x;
        System.out.print("Введите дополнительное количество печенек в миску для кисок ->");
        x = SCANNER.nextInt();
        addFood = x;
       // System.out.println("В миске сейчас печенек для кисок = " + addFood);
    }



}
