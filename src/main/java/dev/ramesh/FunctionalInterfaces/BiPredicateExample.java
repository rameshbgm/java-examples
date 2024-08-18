package dev.ramesh.FunctionalInterfaces;

import java.util.function.BiPredicate;

/**
 * The {@code BiPredicateExample} class demonstrates the usage of the {@link BiPredicate} functional interface.
 *
 * <p>
 * The {@code BiPredicate} interface represents a predicate (boolean-valued function) of two arguments.
 * It is part of the java.util.function package and is intended to be used with lambda expressions or method references.
 * </p>
 *
 * <p>
 * In this example, we use {@code BiPredicate} to evaluate two integer values against certain conditions.
 * Specifically, we use it to check if the first integer is greater than the second integer and to check if both integers are even.
 * The {@code BiPredicate} interface requires a method that takes two input values and returns a boolean result.
 * </p>
 *
 * <p>
 * This example illustrates how to use {@code BiPredicate} to evaluate conditions on two inputs. It is useful in scenarios where
 * you need to test or validate two values based on some criteria and return a boolean result.
 * </p>
 */
public class BiPredicateExample {

    public static void main(String[] args) {
        // Define a BiPredicate to check if the first integer is greater than the second integer
        BiPredicate<Integer, Integer> isGreaterThan = (a, b) -> a > b;

        // Use the BiPredicate to evaluate conditions on two integers
        boolean result = isGreaterThan.test(5, 3);
        System.out.println("Is 5 greater than 3? " + result);
    }
}
