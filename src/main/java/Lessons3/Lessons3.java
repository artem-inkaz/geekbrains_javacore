package Lessons3;

import java.util.Random;
import java.util.Scanner;

public class Lessons3 {
    private static char[][] field;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int fieldSizeX;
    private static int fieldSizeY;

    public static void main(String[] args) {
        while (true) {
            initField();
            printField();

            while (true) {
                humanTurn();
                printField();
                if (checkGame(DOT_HUMAN, "Human wins!!!")) break;
                aiTurn();
                printField();
                if (checkGame(DOT_AI, "AI win!!!")) break;
            }
            System.out.println("Wanna play again?");
            if (!SCANNER.next().equals("y")){
                SCANNER.close();
                break;
            }
        }

    }
//  Итак, что же нужно для хода игрока.
//  Во-первых, создать Scanner для считывания данных из консоли.
//  Во-вторых, перед ходом игрока вывести сообщение о запросе координат.
//  В-третьих, запросить координаты и уменьшить их на 1, так как для игрока удобно вводить координаты в формате 1-3,
//  при том что в массиве это индексы 0-2.
//  После ввода проверить, можно ли поставить фишку в указанную ячейку.
//  Если ячейка свободна и существует, то поставить крестик.
    private static void humanTurn() {
        int x;
        int y;

        do {
            System.out.print("Введите координаты хода Х и У от 1 до 3 через пробел ->");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));

        field[y][x] = DOT_HUMAN;
    }
// Ход компьютера. Для реализации хода компьютера достаточно чуть изменить метод хода игрока, добавив
// туда генератор случайных чисел.
// Метод rand.nextInt(n) возвращает случайное число в диапазоне от 0 до n – 1 включительно.
    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));

        field[y][x] = DOT_AI;
    }

    private static boolean checkGame(char dot, String s) {

        if (checkWin(dot)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!!!");
            return true;
        }
        return false;
    }
//Проверка победы. Необходимо проверить все выигрышные комбинации. Если хотя бы одна будет найдена, вернуть true.
// В приведённом ниже варианте производится проверка всех возможных комбинаций с помощью 8 условий, для поля 3х3
// такой подход может быть оправдан. Если размер поля или длину выигрышной серии можно будет увеличить,
// лучше найти другой вариант проверки победы, например, через циклы(для поля 4х4 придется написать уже не 8, а 24 условия).
    private static boolean checkWin(char c) {
        // hor
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // ver
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // dia
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }
// Инициализация поля. При запуске программы необходимо инициализировать поле и
// заполнить все его ячейки символом, обозначающим пустое поле.
// Заполнение происходит за счёт того, что двойной цикл «пробегает» по
// всем ячейкам массива и в каждую ячейку записывает символ DOT_EMPTY.
    private static void initField() {
        fieldSizeX = 3;
        fieldSizeY = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }
// Вывод поля в консоль. Проинициализированное поле готово. Теперь необходимо вывести его в консоль
// Первый цикл i отвечает за распечатку шапки игрового поля.
// Далее идёт двойной цикл i, j,внутренний j цикл отвечает за печать одной строки, после того как одна строка отпечаталась
// в консоль (закончился цикл j), происходит перевод каретки на следующую строку методом System.out.println().
// После этого счетчик i увеличивается и производится печать следующих строк.
// После распечатки всего поля ставится дополнительная пустая строка для разделения выводов полей.
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }

        for (int i = 0; i <= fieldSizeX * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
    }

    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }
// Проверка ячеек. Метод isCellValid() проверяет возможность установки фишки в указанную ячейку.
// Если введены неверные координаты (либо указывают на занятое поле, либо находятся за его пределами),
// возвращаем false, в противном случае – true.
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }
}
