package ru.geekbrains.homeworks.six;

import java.util.Arrays;

public class HomeworkSix {

    private HomeworkSix(){}

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] arr1 = new Integer[]{1, 2, 4, 5, 6, 7, 8};
        Integer[] arr2 = new Integer[]{1, 2, 3, 5, 6, 7, 4};
        Integer[] arr3 = new Integer[]{1, 2, 3, 5, 6, 7};
        returnAfterNumber(arr, 4);
        returnAfterNumber(arr1, 4);
        returnAfterNumber(arr2, 4);
        returnAfterNumber(arr3, 4);
        checkNumbers(arr, 1, 4);
    }


/*#2*/
    public static boolean checkNumbers(Integer[] numbers, int number1, int number2){
        if(numbers == null || numbers.length == 0){
            return false;
        }
        return Arrays.asList(numbers).contains(number1) & Arrays.asList(numbers).contains(number2);
    }
/*#1*/
    public static void returnAfterNumber(Integer[] arr, int number){
        if(!Arrays.asList(arr).contains(number)){
            throw new RuntimeException("Number " + number + " not found");
        }
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == number) {
                for (int j = i + 1; j < arr.length; j++) {
                    System.out.println(arr[j]);
                }
                break;
            }
        }
    }
}
