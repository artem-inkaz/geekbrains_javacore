package Lessons7;

import Lessons6.Cat;
import Lessons6.Plate;

import java.util.Scanner;

public class Lessons7 {

    // Для ввода из консоли
    private static final Scanner SCANNER = new Scanner(System.in);

    // Запрашиваемые параметры препятствия
    private static int lengthTrack;
    private static int heightWall;

    public static void main(String[] args)  throws MyArraySizeException{

        initialData();

       competitors2();

        exceptionArray();

        exceptionArray2() ;

        exceptionArray3() ;
    }

    // Задаем Входные параметры
    private static void initialData() {
        int x;
        int y;
        System.out.println("Введите высоту препятствия и длину беговой дорожки через пробел ->");
        y = SCANNER.nextInt();
        x = SCANNER.nextInt();
        heightWall = y;
        lengthTrack = x;
        System.out.println("Сегодня высота препятствия= "+ heightWall +" и длину беговой дорожки= "+lengthTrack);


        Wall wall = new Wall();
        wall.heightWall(heightWall);

        RunTrack runTrack = new RunTrack();
        runTrack.lengthTrack(lengthTrack);

    }

    private static void competitors2(){

        JumpRun[] jumpRuns = {

                new Person( "Петр", 1.5f,1000, false),
                new Person("Елена",1,800,false),

                new Cats( "Barsik", 2,150, false),
                new Cats("Izolda",2,180,false),

                new Robot("MaskX28", 3,3000, false),
                new Robot("DjobZ328",2.8f,2800,false)
        };
        //1,
        System.out.println("Сегодня команда состоит из:\r\n");
        for (JumpRun jr : jumpRuns){
                System.out.println(jr);
        }

        System.out.println();
        System.out.println("Сегодня смогли преодолеть все препятствия: \r\n");
        for (JumpRun jr : jumpRuns){
            if (jr.runDo(lengthTrack) && jr.jumpDo(heightWall)) {
                System.out.println(jr);
            }
        }
        System.out.println();
    }

    public static void exceptionArray() {
        try {
        String[][] stringArray = new String[4][4];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {
                stringArray[i][j] = String.valueOf(1);
                System.out.print(stringArray[i][j] + " ");
            }
            System.out.println();
        }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Массив не соответствует заданному размеру");
        } finally {
            System.out.println("It's finally");
        }
    }

    public static void exceptionArray2() throws MyArraySizeException {
       try {
            String[][] stringArray = new String[4][4];

            for (int i = 0; i < stringArray.length; i++) {
                for (int j = 0; j < 6; j++) {
                    stringArray[i][j] = String.valueOf(1);
                    stringArray[j][i] = "A";
                    System.out.print(stringArray[i][j] + " ");
                   throw new MyArraySizeException ("Массив не соответствует заданному размеру");
                }
                System.out.println();
//                throw new MyArraySizeException("Массив не соответствует заданному размеру");
            }
//        throw new MyArraySizeException("Массив не соответствует заданному размеру");

       } catch (MyArraySizeException arraySizeException ) {
//            printStackTrace();
//           arraySizeException.getMessage();
            System.out.println("Массив не соответствует заданному размеру 4x4");
     } finally {
            System.out.println("It's finally");
        }
    }

    public static void exceptionArray3() {
        int arraySum = 0;
        try {
            String[][] stringArray = new String[4][4];

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < stringArray[i].length; j++) {

                    try {
                        stringArray[i][j] = String.valueOf(1);
                        stringArray[2][2] = "A";
                        arraySum += Integer.valueOf(stringArray[i][j]);
//                        System.out.println(arraySum);
                    }catch (NumberFormatException e) {
                        System.err.println("Неверный формат строки!" + stringArray[i][j]);
                        System.err.println("Ошибочный формат элемента [ " +i+" ][ "+j+" ]");
//                        e.setStackTrace(stringArray[i][j] [i][j]);
                        e.printStackTrace();
                    }

                    System.out.print(stringArray[i][j] + " ");
                }
                System.out.println();
            }
//NumberFormatException -	Неверное преобразование символьной строки в числовой формат
//ArrayIndexOutOfВoundsException	Выход индекса за пределы массива
//ClassCastException	Неверное приведение типов
//IndexOutOfВoundsException	Выход индекса некоторого типа за допустимые пределы
//ArithmeticException	Арифметическая ошибка
        } catch (NumberFormatException | ArrayStoreException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Массив не соответствует заданному размеру 4x4");
        } finally {
            System.out.println("Сумма= "+arraySum);

        }
    }

}
