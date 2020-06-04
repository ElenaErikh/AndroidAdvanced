package Lesson_3.HW;

import java.util.*;

public class WordsArray {
    public static void main(String[] args) {
//        Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//        Посчитать, сколько раз встречается каждое слово.

        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "melon", "carrot", "cherry", "pear", "grape",
                "melon", "apple", "kiwi", "mango", "melon", "banana", "olive",
                "grape", "pear", "apple", "pineapple", "banana", "apple"};

        Set<String> wordsSet = new TreeSet<>(Arrays.asList(words));
        System.out.println(wordsSet);

        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        System.out.println(hm);

    }
}
