package dev.ramesh.FunctionalInterfaces;

import java.util.function.BiConsumer;

/**
 * The {@code BiConsumerExample} class demonstrates the usage of the {@link BiConsumer} functional interface.
 *
 * <p>
 * The {@code BiConsumer} interface represents an operation that accepts two input arguments and returns no result.
 * This interface is a part of the java.util.function package and is intended to be used primarily with lambda expressions
 * or method references.
 * </p>
 *
 * <p>
 * In this example, we use {@code BiConsumer} to perform a mathematical operation. Specifically, we use it to print the sum
 * and product of two integers. The first input is the first integer, and the second input is the second integer. The lambda
 * expression provided to the {@code BiConsumer} performs the operations and prints the results.
 * </p>
 *
 * <p>
 * This example shows how to use {@code BiConsumer} for operations where you don't need to return a result but only need
 * to perform some side effect, such as printing or updating a state.
 * </p>
 */
public class BiConsumerExample {

    public static void main(String[] args) {
        // Define a BiConsumer that calculates and prints the sum and product of two integers
        BiConsumer<Integer, Integer> mathOperation = (a, b) -> {
            int sum = a + b;
            System.out.println("Sum: " + sum);
        };

        // Use the BiConsumer with two integers
        mathOperation.accept(5, 3);
    }
}
