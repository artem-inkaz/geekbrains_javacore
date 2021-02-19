package lessons14tests;

import java.util.Arrays;

/**
 * Project java_core_android
 *
 * @Author Alexander Grigorev
 * Created 18.02.2021
 * v1.0
 */
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public static void swap(Integer[] arr, int a){
        int [] arr2 = new int[0];
        int f = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                f=1;
            }
            if (f == 1) {arr2[i]= i;}
        }
        System.out.println(Arrays.toString(arr2));
    }

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



}
