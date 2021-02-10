package Lessons11;

import java.util.*;

public class Lessons11 {

    // Для ввода из консоли
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int cFruit;
    private static int randomFruit;
    private static float boxApple, boxOrange;
    private static int flagApple, flagOrange;
    private int[] array;

    public static void main(String[] args) throws NullPointerException {

        updateSymbol();

        toArrayList();

//        boxArrayOrangeApple();

        initialData();
        try {
            System.out.println(boxOrange + " " + boxApple);

            BoxFruitsArray<Fruit> boxFruitsArrayOrange = new BoxFruitsArray<Fruit>();
            BoxFruitsArray<Fruit> boxFruitsArrayOrange2 = new BoxFruitsArray<Fruit>();
            BoxFruitsArray<Fruit> boxFruitsArrayApple = new BoxFruitsArray<Fruit>();
            BoxFruitsArray<Fruit> boxFruitsArrayApple2 = new BoxFruitsArray<Fruit>();

            flagApple = 0;
            flagOrange = 0;

            for (int i = 0; i < cFruit; i++) {
                randomFruit = RANDOM.nextInt(2);
                if (randomFruit == 0 && flagApple == 0) {
                    boxFruitsArrayApple.add(new Apple(1.0f));
                } else if (randomFruit == 0 && flagApple == 1) {
                    System.out.println(boxFruitsArrayApple.compare(boxFruitsArrayApple2));
                    boxFruitsArrayApple2.add(new Apple(1.0f));
                }
                if (randomFruit == 0 && flagOrange == 0) {
                    boxFruitsArrayOrange.add(new Orange(1.5f));
                } else if (randomFruit == 0 && flagOrange == 1) {
                    System.out.println(boxFruitsArrayOrange.compare(boxFruitsArrayOrange2));
                    boxFruitsArrayOrange2.add(new Orange(1.5f));
                }
                if (boxFruitsArrayApple.getWeight() >= boxApple && flagApple == 0) {
                    System.out.println("Коробка с яблоками полная! Вес: " + boxFruitsArrayApple.getWeight());
                    System.out.println(boxFruitsArrayApple.compare(boxFruitsArrayApple2));
                    System.out.println(boxFruitsArrayApple.toString());
                    flagApple = 1;
//                    break;
                } else if (boxFruitsArrayOrange.getWeight() >= boxOrange && flagOrange == 0) {
                    System.out.println("Коробка с апельсинами полная! Вес: " + boxFruitsArrayOrange.getWeight());
                    System.out.println(boxFruitsArrayOrange.compare(boxFruitsArrayOrange2));
                    System.out.println(boxFruitsArrayOrange.toString());
                    flagOrange = 1;
//                break;
                }
            }
            if (flagApple == 0) {
                System.out.println("Сегодня мало яблок Вес: " + boxFruitsArrayApple.getWeight());
                System.out.println(boxFruitsArrayApple.toString());
            } else if (flagOrange == 0) {
                System.out.println("Сегодня мало апельсин Вес: " + boxFruitsArrayApple.getWeight());
                System.out.println(boxFruitsArrayOrange.toString());
            }

            System.out.println("Дополнительные коробки:");
            System.out.println("C Апельсинами, Вес: " + boxFruitsArrayOrange2.getWeight());
            System.out.println("Состав: " + boxFruitsArrayOrange2.toString());
            System.out.println("C Яблоками, Вес: " + boxFruitsArrayApple2.getWeight());
            System.out.println("Состав: " + boxFruitsArrayApple2.toString());

//            System.out.println(boxFruitsArrayApple.getWeight());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // примеры через ArrayList
    private static void boxArrayOrangeApple() {
        Fruit fruit = new Fruit(1.0f);

        List<Orange> orangeBoxFruit = new ArrayList<>();
        orangeBoxFruit.add(new Orange(1.5f));
        orangeBoxFruit.add(new Orange(1.5f));
        orangeBoxFruit.add(new Orange(1.5f));

//        List<Orange> boxOrange = new List<Orange>(Arrays.asList(orangeBoxFruit.));

        List<Apple> appleBoxFruit = new ArrayList<>();
        appleBoxFruit.add(new Apple(1.0f));
        appleBoxFruit.add(new Apple(1.0f));
        appleBoxFruit.add(new Apple(1.0f));

        for (int i = 0; i < 3; i++) {
            System.out.println(orangeBoxFruit.get(i).toString());
            System.out.println(appleBoxFruit.get(i));
        }

        List<Fruit> boxFruit = new ArrayList<>();
        boxFruit.add(new Apple(1.0f));
        boxFruit.add(new Orange(1.5f));
        boxFruit.add(new Apple(1.0f));

        //       List<Fruit> boxOrange = new ArrayList<Fruit>(boxFruit);

        for (int i = 0; i < 3; i++) {
            System.out.println(boxFruit.get(i).toString());
        }

        BoxFruitsArray<Fruit> boxFruitsArray = new BoxFruitsArray<Fruit>();

        boxFruitsArray.add(new Apple(1.0f));
        boxFruitsArray.add(new Orange(1.5f));
//        boxFruitsArray.addAll(boxFruit);
        boxFruitsArray.addAllWildcards(boxFruit);

        for (int i = 0; i < 3; i++) {
            System.out.println(boxFruitsArray.get(i).toString());
        }
    }

    // не работает
    private static void createBox() {
        String ss = "boxFruitsArrayOrange";
        int n = 0;

        BoxFruitsArray<Fruit> boxFruitsArrayOrange = new BoxFruitsArray<Fruit>();
    }

    // Задаем количество фруктов поступивших, вес коробки
    private static void initialData() {
        int countFruit;
        System.out.println("Введите количество фруктов поступивших на склад ->");
        countFruit = SCANNER.nextInt();
        cFruit = countFruit;
        System.out.println("Введите вес коробки которые поступили на склад для Апельсинов и Яблок, через пробел ->");
        boxOrange = SCANNER.nextFloat();
        boxApple = SCANNER.nextFloat();


    }

    private static void toArrayList() {

        String[] geeks = {"Apple", "Orange", "Cherry", "Lemon"};
        // Варииант 1. Преобразование массива в ArrayList
        // используя Arrays.asList
//        List al = Arrays.asList(geeks);
//        System.out.println(al);

        // Вариант 2. создать новый ArrayList и передать Arrays.asList
        // (ссылка на массив) в качестве аргумента (то есть в качестве аргумента
        // конструктора ArrayList)
        System.out.println("*******************************************************");
        List<String> al1 = new ArrayList<>(Arrays.asList(geeks));
        System.out.println(al1);
        al1.add("Banane");
        al1.add("Maraqua");
        System.out.println(al1);

        //Вариант 3.: использование метода Collections.addAll ()
        System.out.println("====================================================");
        List<String> al2 = new ArrayList<>();
//          al2 = new ArrayList<>();
//        // добавление элементов массива в arrayList.
        Collections.addAll(al2, geeks);
        al2.add("Papaya");
        geeks[0] = "Pear";
        for (String geek : geeks)
            System.out.println(al2);

//        System.out.println(al);

        // Вариант 4.Преобразование массива в ArrayList
        System.out.println("-----------------------------------------");
        List<String> al = new ArrayList<>();
//        al = Arrays.asList(geeks);
        for (String geek : geeks)
            al.add(geek);
        System.out.println(al);
    }
    // замена символов
    private static void updateSymbol() {
        System.out.println("--Меняет два элемента массива местами---");
        String[] geeks = {"Apple", "Orange", "Cherry", "Lemon"};
        List al = Arrays.asList(geeks);
        swap(geeks, 0, 2);
        System.out.println(al);
    }

    public static void swap(String[] array, int a,int b)
    {
        String temp = array[a];
        array[a] = array[b];
        array[b]= temp;
    }
}
