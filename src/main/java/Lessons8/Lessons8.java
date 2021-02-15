package Lessons8;

import Lessons7.MyArraySizeException;

import java.io.*;
import java.util.Scanner;

public class Lessons8 {
    private static int b,c;
    private static String s, s1;

    public static void main(String[] args) throws IOException {


//        oexample();
//        iexample();

//        file();
//        file1();
//        file2();

//ДЗ------------------------------
        file_1();
        file_2();
        file_3();
        file_4();
        mkDir();
        mkfiles();
        file_5();
    }

    private static void oexample()  {
        try {
            FileOutputStream file_o1 = new FileOutputStream("file_1.txt",true);
            FileOutputStream file_o2 = new FileOutputStream("file_2.txt");
            byte[] b = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'} ;
            file_o1.write(b);

            s = "Hello GeekBrains!\n";
            for (int i = 0; i <5; i++) {
                file_o1.write(s.getBytes());
            }

//            file_o1.write(s.getBytes());
            file_o1.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }//finally {
//
//            System.out.println("It's finally FileOutputStream");
//        }
    }

    private static void iexample()  {
        try {
            FileInputStream file_i1 = new FileInputStream("file_1.txt");
            FileInputStream file_i2 = new FileInputStream("file_2.txt");
//            file_i1.read();
            //Вывод содержимого
            while ((c = file_i1.read()) !=-1){
                System.out.print((char)c);
            }
            //Вывод содержимого
            Scanner scanner = new Scanner(file_i1);
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }

            file_i1.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }//finally {

//            System.out.println(" It's finally FileInputStream");
//        }
    }

    public static void file() throws IOException {
        try {
            File file_3 = new File("Example/bin/data/flt.md");
            file_3.createNewFile();
            file_3.getName();
//            file_3.mkdirs();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }//finally {

//            System.out.println(" It's finally FileInputStream");
//        }
    }

    public static void file1() throws IOException {
//        try {
            File file_3 = new File("Example/bin/data");
            String[] strings = file_3.list((dir, name) -> {
                return name.startsWith("fi");
//                    return name.endsWith("txt");
            });
            for (String s : strings) {
                System.out.println(s);
            }

//        String[] strings = file_3.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return name.startsWith("fi");
////                    return name.endsWith("txt");
//            }
//        });
//        for (String s : strings) {
//            System.out.println(s);
//        }
//******************************************************
//            file_3.createNewFile();
//            file_3.getName();
//            file_3.mkdir();
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }catch (IOException ex){
//            ex.printStackTrace();
//            System.out.println(ex.getMessage());
//        }//finally {

//            System.out.println(" It's finally FileInputStream");
//        }
    }

    public static void file2() throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("file_2"));

        for (int i = 0; i <1 ; i++) {
            bos.write(i);
        }
        bos.close();
        BufferedInputStream bis = new BufferedInputStream((new FileInputStream("file_2")));

        int b;
        while ((b=bis.read()) !=-1){
            System.out.println((char) b);
        }
        bis.close();


    }

//1.	Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
    public static void file_1() throws IOException {

       s = "I am a pupil. I am a pupil of the second form.";

    try (
            DataOutputStream dos1 = new DataOutputStream(new FileOutputStream("File_1"));
            DataInputStream dis1 = new DataInputStream(new FileInputStream("File_1"));
    ) {

        dos1.writeBytes(s);
        dos1.close();
        System.out.println("Содержимое первого файла File_1-- ");
        //Записываем в переменную содержимое файла.File_1
        while ((c = dis1.read()) !=-1)
        {
            System.out.print((char) c);
        }
        dis1.close();
        System.out.println("--------------------------------------------");
    }
    catch (FileNotFoundException e){
        e.printStackTrace();
    }catch (IOException e){
        e.printStackTrace();
    }
}

    public static void file_2() throws IOException {

       s1 = "I live in Moscow. I have got a big and friendly family. And I have got a lot of friends.";
        try (
                DataOutputStream dos2 = new DataOutputStream(new FileOutputStream("File_2"));
                DataInputStream dis2 = new DataInputStream(new FileInputStream("File_2"));
        ) {

            dos2.writeBytes(s1);
            dos2.close();
            System.out.println("Содержимое второго файла File_2-- ");
            //Записываем в переменную содержимое файла.File_1
            while ((c = dis2.read()) !=-1)
            {
                System.out.print((char) c);
            }
            dis2.close();;
            System.out.println("--------------------------------------------");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

//2.	Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
    public static void file_3() throws IOException {

//        s= "I am a pupil. I am a pupil of the second form.";
//       s1 = "I live in Moscow. I have got a big and friendly family. And I have got a lot of friends.";
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("File_3"));
                DataInputStream dis1 = new DataInputStream(new FileInputStream("File_1"));
                DataInputStream dis2 = new DataInputStream(new FileInputStream("File_2"));
                DataInputStream  dis = new DataInputStream(new FileInputStream("File_3"))
        ) {
            System.out.println("Содержимое третьего файла File_3-- ");

            //Записываем в переменную содержимое файла.File_1
            while ((c = dis1.read()) !=-1)
            {
                s += String.valueOf((char)c);

            }
            dis1.close();;
            //Добавляем в переменную содержимое файла.File_2
            while ((c = dis2.read()) !=-1)
            {
                s += String.valueOf((char)c);

            }
            dis2.close();
            //Запись в файл File_3 переменной s
            dos.writeBytes(s);
            dos.close();
            // Вывод в консоль содержимого файл File_3
            while ((b=dis.read()) !=-1){
                System.out.print((char) b);
            }
            dis.close();
            System.out.println("--------------------------------------------");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

//3.	* Написать метод, который проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
    public static void file_4() throws IOException {
        int count = 0;
        //Ключевое слово
        s1 = "pupil";
    try (
            DataInputStream  dis = new DataInputStream(new FileInputStream("File_3"));
            Scanner scanner = new Scanner(dis);
    ) {

        //Вывод содержимого
        while (scanner.hasNext()) {
            String keyWord = scanner.next().trim();
            if (keyWord.equals(s1)) {
                ++count;
            }
        }
        if (count>0) System.out.println("Слово: " + s1 +" встречается "+ count + " раз!");
        else System.out.println("Слово: " + s1 + " не встречается ни разу!");
        dis.close();
    }
    catch (FileNotFoundException e){
        e.printStackTrace();
    }catch (IOException e){
        e.printStackTrace();
    }
}

//4.	** Написать метод, проверяющий, есть ли указанное слово в папке
    public static void mkDir() throws IOException {
        File mkDir = new File("Example2/bin/data");
        mkDir.mkdirs();
}

    public static void mkfiles() throws IOException {
        try {
            File file_0 = new File("Example2/bin/data/file.txt");
            File file_1 = new File("Example2/bin/data/file_1.txt");
            File file_2 = new File("Example2/bin/data/file1.txt");
            file_0.createNewFile();
            file_1.createNewFile();
            file_2.createNewFile();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    public static int findWord(File fileA, String fileWord) throws FileNotFoundException
    {
    int count = 0;
    fileWord = fileWord.trim();
    try(Scanner scanner = new Scanner(fileA)) {

        while (scanner.hasNext()) // Fix issue #2
        {
            String nextWord = scanner.next().trim();
            if (nextWord.equals(fileWord)) { // Fix issue #1
                ++count;
            }
        }
        if (count>0) System.out.println("В файле "+ fileA + " cлово: " + s1 +" встречается "+ count + " раз!");
        else System.out.println("В файле "+ fileA + " cлово: " + s1 + " не встречается ни разу!");

    }catch (FileNotFoundException e){
        e.printStackTrace();
    }
    return count;
}
// Укажите файл для поиска вручную в коде в переменную s1
    public static void findFiles(File folder) throws FileNotFoundException {
        s1 = "pupil";
        try {
            File[] folderEntries = folder.listFiles();
            for (File entry : folderEntries) {
                if (entry.isDirectory()) {
                    findFiles(entry);
                    continue;
                } else {
                    findWord(entry, s1);
                }

            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
    //Ввести вручную название каталога в котором будет поиск
    public static void file_5() throws IOException {
        File file_3 = new File("Example2");
        findFiles(file_3);

    }
}
