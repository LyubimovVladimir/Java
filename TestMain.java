package ru.geekbrains.homework.seven;

import java.lang.reflect.Method;

public class TestMain {
        @BeforeSuite(value = "Starting test...")
        public void beforeTest(){
            System.out.println("...");
        }

        @AfterSuite(value = "Test complete")
        public void afterTest(){
            System.out.println("...");
        }


    public static void main(String[] args) {
        try {
            Method before = TestMain.class.getMethod("beforeTest", null);
            BeforeSuite annotationB = before.getAnnotation(BeforeSuite.class);
            System.out.println(annotationB.value());

            Method testOne = TestOne.class.getMethod("add", int.class, int.class);
            Test annotationTOne = testOne.getAnnotation(Test.class);
            System.out.println(annotationTOne.value());

            Method testTwo = TestTwo.class.getMethod("sqrt", double.class);
            Test annotationTTwo = testTwo.getAnnotation(Test.class);
            System.out.println(annotationTTwo.value());

            Method after = TestMain.class.getMethod("afterTest", null);
            AfterSuite annotationA = after.getAnnotation(AfterSuite.class);
            System.out.println(annotationA.value());

        } catch (RuntimeException | NoSuchMethodException e) {
            System.out.println("ERROR");
        }
    }
}
