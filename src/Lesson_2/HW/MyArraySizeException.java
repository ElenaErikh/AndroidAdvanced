package Lesson_2.HW;

/**
 * Данное исключение может быть вызвано когда размер массива не равен 4 х 4.
 * */

public class MyArraySizeException extends RuntimeException{
    final static int ROW_LENGTH = 4;
    final static int COLOMN_LENGTH = 4;

    public MyArraySizeException(String message) {
        super(message);
    }
}
