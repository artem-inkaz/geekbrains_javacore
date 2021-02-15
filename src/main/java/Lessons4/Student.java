package Lessons4;

// 1. Создать класс "Сотрудник" с полями:  Фио, должность, email, телефон, зарплата, возраст.
public class Student {
  public    int id;
  public  String fio;
  public  String email;
  public String phoneNumber;
  public  String position;
  public   int age;
  public   int salary;

// 2. Конструктор с данными по умолчанию. Конструктор класса заполняет эти поля при создании объекта.
    public Student() {
        id = 11;
        fio = "Semenov Nikolay";
        email = "nik@gmail.com";
        phoneNumber = "89234567898";
        position = "Product manager";
        age = 43;
        salary = 500000;
    }
// 3. Внутри класса «Сотрудник» метод, который выводит информацию об объекте в консоль.
    public void getinfo() {
        System.out.println("id: " + id + "; Фио Студента: " + fio+ "; Email: " + email+ "; Телефон: " + phoneNumber +"; Должность: " + position + "; Возраст: " + age+"; Зарплата: " + salary );
    }

// 4. Конструктор для массива Студентов. Создать массив из 5 сотрудников.
    public Student (int id, String fio, String email,String phoneNumber, String position, int age, int salary){
        this.id = id;
        this.fio = fio;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.age = age;
        this.salary = salary;

    }

// 3.1
    public void changePosition(int salary) {
        this.salary = salary;
        System.out.println("Студент " + fio + " Получил работу с окладом: " + salary);
    }

// Выборка Студентов по возрасту вариации
    public void queryAge(int queryage) {
        if (queryage <= this.age) {
            System.out.println("Студенту " + fio+ " больше 40 лет");
        } else {
            System.out.println("Студенту " + fio+ " еще нет 40 лет");
        }
    }

    public boolean queryAgeBoolean(int queryage) {
        if (queryage <= this.age) return true;
        return false;
    }

    public boolean queryAgeBoolean1(int queryage) {
           return queryage <= this.age;
    }

    public Student (int age, String fio){
        this.age = age;
 //       this(fio);

    }
   //  Выводим инфу по полю Age
    public int getAge() {
        return age;
    }

    // Вводим коректный возраст, такие проверки можно сделать на поля age, phoneNumber, salary
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Введен некорректный возраст");
        }
    }
}
