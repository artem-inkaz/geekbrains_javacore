package Lessons3;

import java.util.Random;
import java.util.Scanner;

public class Lessons3_2 {
    // Для ввода из консоли
    private static final Scanner SCANNER = new Scanner(System.in);
    // размеры поля
    private static int m;
    private static int n;
   // игровое поле
    public static void main(String[] args) {

        fieldSize();
//        int m = 6;
//        int n = 6;
        //задаем числа внутри массива начиная с 0.
        int s = 1;
        //инициализируем массив.
        int[][] array = new int[m][n];

        //Заполняем периметр массива по часовой стрелке.

        for (int y = 0; y < n; y++) {
            array[0][y] = s;
            s++;
        }
        for (int x = 1; x < m; x++) {
            array[x][n - 1] = s;
            s++;
        }
        for (int y = n - 2; y >= 0; y--) {
            array[m - 1][y] = s;
            s++;
        }
        for (int x = m - 2; x > 0; x--) {
            array[x][0] = s;
            s++;
        }

        //Периметр заполнен. Продолжаем заполнять массив и задаём
        //координаты ячейки, которую необходимо заполнить следующей.
        int c = 1;
        int d = 1;

        while (s < m * n) {
           //Заполняем ячейки.
            //Вложенный цикл останавливается, если следующая ячейка имеет
            //значение, отличное от ноля. Ячейка, на которой остановился
            //цикл, не заполняется.

            //Движемся вправо.
            while (array[c][d + 1] == 0) {
                array[c][d] = s;
                s++;
                d++;
            }

            //Движемся вниз.
            while (array[c + 1][d] == 0) {
                array[c][d] = s;
                s++;
                c++;
            }

            //Движемся влево.
            while (array[c][d - 1] == 0) {
                array[c][d] = s;
                s++;
                d--;
            }

            //Движемся вверх.
            while (array[c - 1][d] == 0) {
                array[c][d] = s;
                s++;
                c--;
            }
        }

        //Заполняем Центр
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (array[x][y] == 0) {
                    array[x][y] = s;
                }
            }
        }
        //Выводим массив в консоль.
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (array[x][y] < 10) {
                    //Два пробела, чтобы в консоли столбцы были ровные.
                    System.out.print(array[x][y] + ",  ");
                } else {
                    System.out.print(array[x][y] + ", ");
                }
            }
            System.out.println("");
        }
    }
    // Задаем размер поля
    private static void fieldSize() {
        int x;
        System.out.print("Введите размер поля ->");
        x = SCANNER.nextInt();
        m = x;
        n = x;
        System.out.println("Размер игрового поля: "+m+ " х "+n );
    }

}
