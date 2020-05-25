package Lesson_3.HW.Phonebook;

import java.util.*;

public class Phonebook{
    HashMap<String, Set<String>> phonebook;
    Set<String> nums;

    public Phonebook(HashMap phonebook) {
        this.phonebook = phonebook;
    }

    public void get(String surname) {
        System.out.println(surname + ": " + phonebook.get(surname));
    }

    public void add(String surname, String phoneNumber){
        nums = new LinkedHashSet<>();

        if (phonebook.get(surname) == null){
            nums.add(phoneNumber);
            phonebook.put(surname, nums);
        } else {
            nums = phonebook.get(surname);
            nums.add(phoneNumber);
            phonebook.put(surname, nums);
        }

    }

}
