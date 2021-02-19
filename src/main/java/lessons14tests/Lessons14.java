package lessons14tests;

import java.util.ArrayList;
import java.util.List;

public class Lessons14 {

//    public static void main(String[] args) {
//        int[] intArray = {11, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
//        check1 (intArray,11);
////        int[] intArray2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
////        check2(intArray2,1,4);
//    }
//    public static void check1(int[] arr, int a){
//        List<Integer> list = new ArrayList<>();
//        int f = 0;
//        int j = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == a) {
//                f=1;
//            }
//
//                if (arr[i] == a && f == 1) {
//        list.clear();
//    }
//
//            if (f == 1 && i+1 < arr.length) {
//                list.add(arr[i+1]);
//            }
//        }
//
//        System.out.println(list);
//    }

//    public static void check2(int[] arr, int a, int b){
//        int f1 = 0;
//        int f2 = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == a)  {f1 = 1;}
//            if (arr[i] == b)  {f2 = 1;}
//        }
//            if (f1 == 1 && f2 == 1) {
//                System.out.println(true);
//            }
//        System.out.println(false);
//    }
//

    // для тестов
    public Integer[] check1(int[] arr, int a){
        List<Integer> list = new ArrayList<>();
        int f = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                f=1;
            }
            if (arr[i] == a && f == 1) {
                list.clear();
            }

            if (f == 1 && i+1 < arr.length) {
                list.add(arr[i+1]);
            }
        }
        Integer[] arr3 = new Integer[list.size()];
        list.toArray(arr3);

        return arr3;
    }

    public boolean check2(int[] arr, int a, int b){
        int f1 = 0;
        int f2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a)  {f1 = 1;}
            if (arr[i] == b)  {f2 = 1;}
        }
        if (f1 == 1 && f2 == 1) {
            return true;
        } else return false;

    }


}
