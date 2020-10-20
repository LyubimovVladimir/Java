package ru.geekbrains.homework.seven;

public class TestOne {

    @Test(value = 5, priority = Test.Priority.LOW)
    public int add(int a, int b){
        return a + b;
    }
}
