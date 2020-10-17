package ru.geekbrains;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import ru.geekbrains.homeworks.six.HomeworkSix;

import java.util.stream.Stream;

public class HomeworkSixTest {

    @ParameterizedTest
    @MethodSource("numbersNotFound")
    public void shouldNotFindNumbers(Integer[] numbers, int number1, int number2){
        Assertions.assertFalse(HomeworkSix.checkNumbers(numbers, number1, number2));
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void shouldRejectNulls(Integer[] numbers){
        Assertions.assertFalse(HomeworkSix.checkNumbers(numbers, 4, 1));
    }

    private static Stream<Arguments> numbersNotFound(){
        return Stream.of(
                Arguments.arguments(new Integer[]{}, 4, 1),
                Arguments.arguments(null, 4, 1),
                Arguments.arguments(new Integer[]{1, 2, 3, 5}, 4, 1)
                );
    }
}
