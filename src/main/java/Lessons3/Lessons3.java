package Lessons3;

import java.util.Random;
import java.util.Scanner;

public class Lessons3 {
    // игровое поле
    private static char[][] field;
    private static int[][] arrayField;
    //фишка игрока
    private static final char DOT_HUMAN = 'X';
    //фишка компьютера
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    // Для ввода из консоли
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    // размеры поля
    private static int fieldSizeX;
    private static int fieldSizeY;
    // уровень сложности
    private static int levelgame;
    // количество шагов
    private static int gamePoint;

    public static void main(String[] args) {
        while (true) {
            gameLevel();
            fieldSize();
            initField();
            printField();

            while (true) {
                humanTurn();
                printField();
             //   if (gamePoint == 10)  playStop();
                if (checkGame(DOT_HUMAN, "Human wins!!!")) break;
                aiTurn();
                printField();
                if (checkGame(DOT_AI, "AI win!!!")) break;
            }
            playGame();
        }
      // playStop();
    }
// Предложить продолжить игру или закончить
    private static boolean playGame() {
        System.out.println("Wanna play again?");
        if (!SCANNER.next().equals("y")){
            SCANNER.close();
            return false;
        }
        return true;
    }
    // Предложить продолжить или закончит игру когда игра длится долго или предложить
    // закончить когда сделано 10 вводов
    private static boolean playStop() {
        while (gamePoint != 5) {
            if (gamePoint == 5) {
                System.out.println("Wanna exit game and have a cap of coffee? Y/N");
                if (SCANNER.next().equals("y")) {
                    SCANNER.close();
                    break;
                }
            }
        }
        return false;
    }
// Задаем размер поля
    private static void fieldSize() {
        int x;
        System.out.print("Введите размер поля ->");
        x = SCANNER.nextInt();
        fieldSizeX = x;
        fieldSizeY = x;
        System.out.println("Размер игрового поля: "+fieldSizeX+ " х "+fieldSizeY );
    }
// Задаем уровень сложности игры
private static void gameLevel() {

    System.out.print("Введите желаемый уровень сложности 1. Начинающий 2. Мастер ->");
    levelgame = SCANNER.nextInt();

}
//  3.так, что же нужно для хода игрока.
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
            System.out.print("Введите координаты хода Х и У от 1 до " + fieldSizeX + " через пробел ->");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
            gamePoint= gamePoint+1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));

        field[y][x] = DOT_HUMAN;
    }
// 6. Ход компьютера Уровень начинающий. Для реализации хода компьютера достаточно чуть изменить метод хода игрока, добавив
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

    private static void aiTurn2() {
    int i = -1;
    int j = -1;
            for (int y = 0; y < fieldSizeY; y++)
            {
                for (int x = 0; x < fieldSizeX; x++)
                {
                    if (!isCellEmpty(y, x))
                    {
                    i = y;
                    j = x;
                        field[y][x] = DOT_AI;
                        break;
                    }
//                    field[i][j] = DOT_EMPTY;
                }
//                field[i][j] = DOT_EMPTY;
            }
    }

// 9. Общая дополнительная проверка
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
//7. Проверка победы. Необходимо проверить все выигрышные комбинации. Если хотя бы одна будет найдена, вернуть true.
// В приведённом ниже варианте производится проверка всех возможных комбинаций с помощью 8 условий, для поля 3х3
// такой подход может быть оправдан. Если размер поля или длину выигрышной серии можно будет увеличить,
// лучше найти другой вариант проверки победы, например, через циклы(для поля 4х4 придется написать уже не 8, а 24 условия).
    private static boolean checkWin(char c) {
        int checkX = 0;
        int checkY = 0;
        int diagX = 0;
        int diagY = 0;
// Проверка диагонали
        for (int i =0; i< fieldSizeY; i++) {
            if (field[i][i] == c ) diagX = diagX+1;
            if (field[i][fieldSizeY-i-1] == c ) diagY = diagY+1;
        }
        if (diagX == fieldSizeX || diagY == fieldSizeY) return true;
// Проверка вертикали и горизонтали
        for (int y = 0; y < fieldSizeY; y++) {
          checkX = 0;
          checkY = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == c ) checkX = checkX+1;
                if (field[x][y] == c ) checkY = checkY+1;
                if (checkX == fieldSizeX || checkY == fieldSizeY) return true;
            }
            if (checkX == fieldSizeX && checkY == fieldSizeY) return true;
        }

// Прямой перебор
          // hor
//        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
//        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
//        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;
//
//        // ver
//        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
//        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
//        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;
//
//        // dia
//        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
//        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
    }
//8. Проверкаа на ничью
    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }
// 1.нициализация поля. При запуске программы необходимо инициализировать поле и
// заполнить все его ячейки символом, обозначающим пустое поле.
// Заполнение происходит за счёт того, что двойной цикл «пробегает» по
// всем ячейкам массива и в каждую ячейку записывает символ DOT_EMPTY.
    private static void initField() {
//        fieldSizeX = 4;
//        fieldSizeY = 4;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }
// 2.Вывод поля в консоль. Проинициализированное поле готово. Теперь необходимо вывести его в консоль
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
// 4.Проверяем не занято ли поле и в поле стоит "."
    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }
// Проверка ячеек. Метод isCellValid() проверяет возможность установки фишки в указанную ячейку.
// Если введены неверные координаты (либо указывают на занятое поле, либо находятся за его пределами),
// возвращаем false, в противном случае – true.
    //5. Проверка ввел ли игрок координаты не превышающие размеры поля
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

}
