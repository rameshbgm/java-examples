package dev.ramesh.FunctionalInterfaces;

import java.util.function.BiFunction;

/**
 * The {@code BiFunctionExample} class demonstrates the usage of the {@link BiFunction} functional interface.
 *
 * <p>
 * The {@code BiFunction} interface represents a function that takes two arguments and produces a result.
 * It is a part of the java.util.function package and is designed to be used with lambda expressions or method references.
 * </p>
 *
 * <p>
 * In this example, we use {@code BiFunction} to perform mathematical operations. Specifically, we use it to calculate
 * the sum and product of two integers. The {@code BiFunction} interface requires a method that takes two input values
 * and produces an output. In this case, the output is the result of the specified operation.
 * </p>
 *
 * <p>
 * This example illustrates how to use {@code BiFunction} to perform calculations and return a result based on two inputs.
 * It is useful when you need to apply a function that produces a result using two input values.
 * </p>
 */
public class BiFunctionExample {

    public static void main(String[] args) {
        // Define a BiFunction that calculates the sum of two integers
        BiFunction<Integer, Integer, Integer> sumFunction = (a, b) -> a + b;

        // Use the BiFunction to calculate and print the sum and product of two integers
        System.out.println("Sum: " + sumFunction.apply(5, 3));
    }
}
