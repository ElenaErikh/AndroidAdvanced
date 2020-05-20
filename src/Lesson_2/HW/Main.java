package Lesson_2.HW;

import Lesson_2.HW.MyArrayDataException;
import Lesson_2.HW.MyArraySizeException;

public class Main {

    static int sum = 0;

    public static void main(String[] args) {

        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "java", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15"}
        };

        try {
            someMethod(array);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e){
            e.printStackTrace();
        }
        System.out.println("Сумма элементов равна: " + sum);
    }

    static int someMethod(String [][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr.length < MyArraySizeException.ROW_LENGTH ||
                        arr[i].length < MyArraySizeException.COLOMN_LENGTH) {
                    throw new MyArraySizeException("Размер массива должен быть 4 х 4");
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e){
                    throw new MyArrayDataException("Не удалось преобразовать данные из ячейки [" + i + "]["
                            + j + "]. Неверный формат.");
                }
            }
        }
        return sum;
    }
}
