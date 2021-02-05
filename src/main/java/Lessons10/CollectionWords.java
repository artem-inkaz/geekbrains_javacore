package Lessons10;

import Lessons6.Cat;

import java.util.*;

public class CollectionWords {

    public static void main(String[] args) {
//        task1();
        hashSet();
//        linkedHashMap();


    }

    private static void linkedHashMap() {
        LinkedHashMap<String, String> phoneBook = new LinkedHashMap<>();
        phoneBook.put( "Petrov","891226745344");
        phoneBook.put( "Petrov","894727845388");
        phoneBook.put( "Samoylov","89054521236");
        phoneBook.put( "Kuzmin","89994175278");
        phoneBook.put( "Romanov","89651258579");
        System.out.println(phoneBook);
    }

    private static void hashSet() {
//        TelefonBook telefonBook = new TelefonBook("Petrov","891226745344");
        TelefonBook[]  telefonBook = new TelefonBook[5];
        telefonBook[0] = new TelefonBook( "Petrov","891226745344");
        telefonBook[1] = new TelefonBook( "Petrov","894727845388");
        telefonBook[2] = new TelefonBook( "Samoylov","89054521236");
        telefonBook[3] = new TelefonBook( "Kuzmin","89994175278");
        telefonBook[4] = new TelefonBook( "Romanov","89651258579");
        LinkedHashSet<TelefonBook> books = new LinkedHashSet<>();
        books.add(telefonBook[0]);
        books.add(telefonBook[1]);
        books.add(telefonBook[2]);
        books.add(telefonBook[3]);
        books.add(telefonBook[4]);
        System.out.println(books);
        System.out.println();
//        telefonBook[0].getBook("Romanov");
//        books.contains("Petrov");
        for (int i = 0; i < books.size(); i++) {
            if (telefonBook[i].fio == "Petrov") System.out.println(telefonBook[i].toString());
        }
//        System.out.println(telefonBook[0].getBook("Petrov"));
//        System.out.println(books.contains("Petrov"));
    }

    private static void task1() {
        int w = 0;
        int ww = 1;
        String s;
        List<String> words = new ArrayList<>();
        List<String> uniqalwords = new ArrayList<>();
        List<String> allWords = new ArrayList<>();
        List<String> allCountWords = new ArrayList<>();

        LinkedHashMap<String, String> hm = new LinkedHashMap<>();

        words.add("Компот");
        words.add("Бегемот");
        words.add("Бежемот");
        words.add("Жмот");
        words.add("Компот");
        words.add("переворот");
        words.add("Мишень");
        words.add("Мишень");
        words.add("Жмот");
        words.add("Берег");
        words.add("река");
        words.add("Русло");
        words.add("Бежемот");
        words.add("Бежемот");
        System.out.println(words.toString());
        System.out.println();
//        words.forEach();
//        s ="Бежемот";
        while (w!=words.size()){
            for (String word : words) {
                if (words.get(w).equals(word)) ++ww;
            }
            // добавляем в лист уникальных
            if (ww == 1) uniqalwords.add(words.get(w));
            // добавляем в лист все слова исключая повторяющиеся
           if (!allWords.contains(words.get(w))) {allWords.add(words.get(w));}
//          Добавляем w и ww в коллекцию ключ-значение
            ++w;
            ww=0;
        }
        w = 0;
        ww = 0;
        System.out.println("Уникальные слова: " + uniqalwords);
        System.out.println();
        System.out.println("Все слова без повторяющихся: " + allWords);
        System.out.println();
        // подсчет каждого слова в списке
        for (int i = 0; i < allWords.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (allWords.get(i) == words.get(j)) ++w;
            }
            allCountWords.add(allWords.get(i) + " "+ w + " раз");

            hm.put(allWords.get(i), String.valueOf(w));

            // вариант распечатки
//            System.out.println("Слово: " + allWords.get(i) + " встречается: " + w + " раз");
            w = 0;
        }
        // вариант распечатки списка с подсчитанными словами
        System.out.println(allCountWords);
        System.out.println();
        System.out.println(hm);

//        Iterator<String> iterator = words.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
    }
}
