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
            // System.out.println("arr[" + i + "] = " + intArray[i]);
        }
        System.out.println(Arrays.toString(intArray));
    }

    //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void thirdTask() {

        int[] intArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < intArray.length; i++) {

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

                System.out.print(intArray[i][j] + " ");
            }

            System.out.println();
        }
    }

//** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
public static void fifthTask() {

    int[] intArray = {1, 5, 3, 2, 11, 4, 5, 2, 40, 8, 9, 14};
    int max=0;
    int min=intArray[1];
    for (int i = 0; i < intArray.length; i++) {

        if (intArray[i] > max) max = intArray[i];
        if (intArray[i] <= min) min = intArray[i];
    }
    System.out.println(max);
    System.out.println(min);
}

//** Написать метод, в который передается не пустой одномерный целочисленный массив,
// метод должен вернуть true, если в массиве есть место, в котором сумма левой и
// правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
// checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
public static void sixthTask() {

   // int[] intArray = {2, 2, 2, 1, 2, 2, Integer.parseInt("||"), 10, 1};
   // int l1=intArray[1];
   // int l2=intArray[2];
    boolean boll;
  //  int r1=intArray[1];
  //  int r2=intArray[2];
    int k = Integer.parseInt("||",1);
    System.out.println(k);
//    for (int i = 0; i <intArray.length; i++) {
//
//        if (intArray[i] == k) break;
//
//        if (intArray[i] == k && intArray[i] +intArray[i+1] == intArray[k-1] +intArray[k-2]) System.out.println(true);
//        else System.out.println(false);
//    }

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

        //    if (right>0)
         //   {
            for (int i=0; i< intArray.length-1; i++)
            {
               // intArray[i]=intArray[i];
                if (i!=0) intArray[i+1]=intArray[i];
                if (i==0) intArray[i]=intArray[j];intArray[j]=intArray[intArray.length-1];
            }
                System.out.println(Arrays.toString(intArray));
        //    }


//        if (intArray[i] <= min) min = intArray[i];
    //    System.out.println(Arrays.toString(intArray));
    }

//}

}