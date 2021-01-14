package ru.geekbrains;

public class FirstApp {

    public static void main(String[] args) {
//        System.out.println("Hello World");
//        System.out.println("Hello GeekBrains");
//2.	Создать переменные всех пройденных типов данных и инициализировать их значения

        short i =1244;
        long j = 1245L;
        float f = 1.23f;
        boolean bool = true;
        byte byt = -100;
        double doub = 124.125;
        char ch= 'a';
        String str ="Hello GeekBrains";

        System.out.println(abcd(2, 2, 2, 2));
        System.out.println(add(5, 6));
        add(-30);
        System.out.println(add2(10));
        str1("Петя");
 //       Year(1964);

}
    //3.	Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    //где a, b, c, d – аргументы этого метода, имеющие тип float.
    public static float abcd (float a, float b, float c, float d ){

        return a * (b + (c / d));

    }
//4.	Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма
// лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
        public static boolean add (int a, int b) {
            int summ =a+b;

            if ( summ>=10 && summ<=20) return true;
         else return false;
    }

    //5.	Написать метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    // Замечание: ноль считаем положительным числом.

        public static void add(int a) {
        if ( a>=0) System.out.println("Вы ввели положительное число");
        else System.out.println("Вы ввели отрицательное число");
    }

//    6.	Написать метод, которому в качестве параметра передается целое число.
//    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
        public static boolean add2(int a) {

            if ( a>=0) return false;
            else return true;
}

//7.	Написать метод, которому в качестве параметра передается строка, обозначающая имя.
// Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    public static void str1(String name){
        name="Geekbrains";
        System.out.println("Привет " + name+ " !");
    }

    //*Написать метод, который определяет, является ли год високосным, и выводит сообщение в
    // консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый
    // 400-й – високосный.
    public static void Year(int a) {
        //int flag;
//        a%=400;
//        if (a==0) System.out.println("Год високосный");
//
//        System.out.println(a%=4);
//        System.out.println(a%=100);
//        System.out.println(a%=400);
      //  if ( a%4==0) System.out.println("Вы ввели положительное число");
      //  else System.out.println("Вы ввели отрицательное число");
    }

}
