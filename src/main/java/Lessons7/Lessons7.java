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

    public static void main(String[] args) {

        initialData();

       competitors2();
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
        System.out.println();
        for (JumpRun jr : jumpRuns){
                System.out.println(jr);
        }

        System.out.println();
        System.out.println("Сегодня смогли преодолеть все препятствия: \r\n");
        System.out.println();
        for (JumpRun jr : jumpRuns){
            if (jr.runDo(lengthTrack) && jr.jumpDo(heightWall)) {
                System.out.println(jr);
            }
        }

    }

}
