package Lessons2;

import java.util.Arrays;

public class Lessons2 {
    public static void main(String[] args) {


        firstTask();
        secondTask();
        thirdTask();
        fourthTask();
        fifthTask();
        sixthTask();
        seventhTask();

    }


//Задать целочисленный массив, состоящий из элементов 0 и 1.
// Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public static void firstTask() {
        int[] intArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < intArray.length; i++) {

            if (intArray[i] == 0) {
                intArray[i] = 1;

            } else if (intArray[i] == 1) {
                intArray[i] = 0;
            }
        // по битовое исключение вместо if else
        //    intArray[i] ^= 1;
        //    intArray[i] = intArray[i] ^ 1;
            //варианты
        //    intArray[i] = (intArray[i] +1) % 2;
        //    intArray[i] = (intArray[i] -1) * -1;
        }
        System.out.print(Arrays.toString(intArray));


    }

    //Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void secondTask() {

        int[] intArray = new int[7];
        int a = 0;
        for (int i = 0; i < intArray.length; i++) {
            a = a + 3;
            intArray[i] = a;
            //вариант
          //  intArray[i] = i * 3;

          // System.out.println("arr[" + i + "] = " + intArray[i]);
        }
        System.out.println(Arrays.toString(intArray));
    }

    //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void thirdTask() {

        int[] intArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < intArray.length; i++) {
            // вариант
       //     intArray[i] = intArray[i] < 6 ? intArray[i] * 2 : intArray[i];

            if (intArray[i] < 6) intArray[i] = intArray[i] * 2;

        }
        System.out.println(Arrays.toString(intArray));
    }

    //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void fourthTask() {

        int[][] intArray = new int[2][2];

        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[i].length; j++) {

                if (i==j)   intArray[i][j] = 1;
                intArray[i][intArray[i].length-i -1] = 1;
                System.out.print(intArray[i][j] + " ");
            }

            System.out.println();
        }
    }

//** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
public static void fifthTask() {

    int[] intArray = {1, 5, 3, 2, 11, 4, 5, 2, 40, 8, 9, 14};
    int max=intArray[0];
    int min=intArray[0];
   // for (int i = 0; i < intArray.length; i++) {
    for (int i :intArray) {
        if (min > i) min = i;
        if (max < i) max = i;
    }
   // System.out.println(max);
   // System.out.println(min);
    System.out.printf("Min = %d \r\nMax = %d\r\n", min, max);
}

//** Написать метод, в который передается не пустой одномерный целочисленный массив,
// метод должен вернуть true, если в массиве есть место, в котором сумма левой и
// правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
// checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
public static void sixthTask() {

    int[] intArray = {2, 2, 2, 1, 2, 2, 10, 1};

    System.out.println(checkBalance(intArray));

}
    static boolean checkBalance(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) return false;

        sum /= 2;
        int left = 0;

        for (int i : arr) {
            left += i;
            if (left == sum) return true;
            if (left > sum) return false;
        }

        return false;
    }

//**** Написать метод, которому на вход подается одномерный массив и
// число n (может быть положительным, или отрицательным),
// при этом метод должен сместить все элементы массива на n позиций.
// Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
// Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
// При каком n в какую сторону сдвиг можете выбирать сами.
public static void seventhTask() {

    int[] intArray = {1, 5, 3, 2};
    int right=1;
 //   int left=-2;
    int j =intArray.length-1;
  //  for (int i = 0; i < intArray.length; i++) {
   // int j = intArray.length;

    System.out.println(Arrays.toString(intArray));

    shift(intArray, -4);

    System.out.println(Arrays.toString(intArray));
    }

    static void shift(int[] arr, int n) {
        int shift = (arr.length + n % arr.length) % arr.length;

        for (int i = 0; i < shift; i++) {
            int temp = arr[arr.length - 1];
//                System.arraycopy(arr, 0, arr, 1, arr.length - 1);
            for (int j = arr.length - 1; j > 0 ; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
    }

}