package Lesson_3.HW.Phonebook;

import java.util.*;

public class Phonebook{
    HashMap<String, Set<String>> phonebook;

    private String surname;
    private String phoneNumber;

    public Phonebook(HashMap phonebook) {
        this.phonebook = phonebook;
    }

    public void get(String surname) {
        System.out.println(surname + ": " + phonebook.get(surname));
    }

    public void add(String surname, String phoneNumber){
        if (phonebook.get(surname) == null) {
            Set<String> nums = new LinkedHashSet<>();
            nums.add(phoneNumber);
            phonebook.put(surname, nums);
        } else {
            phonebook.get(surname).add(phoneNumber);
            phonebook.put(surname, phonebook.get(surname));
        }
    }

}
