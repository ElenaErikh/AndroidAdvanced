package Lesson_3.HW.Phonebook;

import java.util.*;

public class Main {
//    Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
//    В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get()
//    искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов,
//    тогда при запросе такой фамилии должны выводиться все телефоны.

    public static void main(String[] args) {

        HashMap<String, String> book = new HashMap<>();
        Phonebook phonebook = new Phonebook(book);

        phonebook.add("Иванов", "89154560011");
        phonebook.add("Иванов", "89197785462");
        phonebook.add("Петров", "89155681474");
        phonebook.add("Погорелов", "89153258741");
        phonebook.add("Тюльпанов", "89157891278");
        phonebook.add("Тюльпанов", "89064013044");
        phonebook.add("Сидоров", "89152215820");
        phonebook.add("Жданов", "89154807125");
        phonebook.add("Жданов", "89289741177");

        phonebook.get("Иванов");
        phonebook.get("Сидоров");
        phonebook.get("Тюльпанов");

    }
}
