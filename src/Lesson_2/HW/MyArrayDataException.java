package Lesson_2.HW;

/**
 * Данное исключение может быть вызвано если в каком-то элементе массива преобразование не удалось
 * (например, в ячейке лежит символ или текст вместо числа).
 * */

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException (String message){
        super(message);
    }



}
