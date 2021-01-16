package Lessons4;

import java.util.Scanner;

public class Lessons4 {

    // Для ввода из консоли
    private static final Scanner SCANNER = new Scanner(System.in);
    // Запрашиваемый возраст
    private static int ageStudent;

    public static void main(String[] args) {

//   int id, fio, email, phoneNumber position, age, salary;
    Student student11;
    student11= new Student();

     Student student1;
     student1= new Student();
// Пользовательские данные
     student1.id = 2;
     student1.fio = "Seleznev Boris";
     student1.email = "art@gmail.com";
     student1.phoneNumber = "87771232314";
     student1.position = "CPO";
     student1.age = 35;
     student1.salary = 123000;

//     System.out.println("Первый студент "+ student1.id);

// вывод общей информации о Seleznev Boris
     System.out.println("2. Вывод общей информации о Данных заданных пользователем");
     student1.getinfo();

// вывод  информации о зарплате Seleznev Boris
//     student1.changePosition(450000);

// вывод общей информации о Данных по умолчанию заданных в конструкторе
     System.out.println("2. Вывод общей информации о Данных по умолчанию заданных в конструкторе");
     student11.getinfo();

//4. Создание массива Студентов Пользовательские данные
    Student[]  studentArray = new Student[5];
    // int id, fio, email, phoneNumber, position, age, salary;
    studentArray[0] = new Student(1, "Ivanov Peter","ivivan@mailbox.com", "89231234712", "CEO", 55, 1000000);
    studentArray[1] = new Student(2, "Korik Yana","yana@mailbox.com", "89741235742", "Designer", 25, 130000);
    studentArray[2] = new Student(3, "Shulz Nik","nik@mailbox.com", "+10452892312312", "CPO", 33, 300000);
    studentArray[3] = new Student(4, "Salihanuly Saat","pet@mailbox.com", "892312312", "Product manager", 41, 200000);
    studentArray[4] = new Student(5, "Krause Kat","kat@mailbox.com", "892312312", "Project manager", 37, 190000);
// Вариант объявления массива и печать
//    Student[] students = {
//            new Student(1, "Ivanov Peter","ivivan@mailbox.com", "89231234712", "CEO", 55, 1000000),
//            new Student(3, "Shulz Nik","nik@mailbox.com", "+10452892312312", "CPO", 33, 300000)
//    };
//    for (Student student : students){
//        student.getinfo();
//    }
//    System.out.println("Первый студент "+ studentArray[0].id);

// вывод общей информации о Данных заданных пользователем заданных в массиве
//    studentArray[0].getinfo();

//   Запросы через методы класса
//    studentArray[4].changePosition(450000);
//    studentArray[4].queryAge(50);
//    studentArray[3].queryAgeBoolean(35);
     System.out.println("\r\n");
//   Запрашиваем какой возраст хотим отсортировать
        queryAge();

//5. С помощью цикла выводим информацию только о сотрудниках удовлетворяющих критерию.
        for (int i = 0; i < studentArray.length; i++) {

            if (studentArray[i].queryAgeBoolean1(ageStudent))
            {
                System.out.println("Cтудентy: "+ studentArray[i].fio+" больше: "+ ageStudent+ " лет " +studentArray[i].age+ " лет сейчас");
            }

        }


//        if (studentArray[3].queryAgeBoolean(ageStudent))
//        {
//            System.out.println("Cтудентy: "+ studentArray[3].fio+" больше: "+ ageStudent+ " лет " +studentArray[3].age+ " лет сейчас");
//        } else  System.out.println("Cтудентy: "+ studentArray[3].fio+" меньше: "+ ageStudent+ " лет На данный момент " +studentArray[3].age+ " лет");
    }

    // Задаем Возраст для выборки
    private static void queryAge() {
        int x;
        System.out.print("Введите возраст студентов для сортировки ->");
        x = SCANNER.nextInt();
        ageStudent = x;
    }
}
