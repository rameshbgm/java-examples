package dev.ramesh.FunctionalInterfaces;

import java.util.function.BinaryOperator;

/**
 * The {@code BinaryOperatorExample} class demonstrates the usage of the {@link BinaryOperator} functional interface.
 *
 * <p>
 * The {@code BinaryOperator} interface is a specialization of the {@link java.util.function.BiFunction} interface.
 * It represents an operation that takes two input arguments of the same type and produces a result of the same type.
 * It is part of the java.util.function package and is commonly used with lambda expressions or method references.
 * </p>
 *
 * <p>
 * In this example, we use {@code BinaryOperator} to perform mathematical operations on two integers. Specifically, we
 * use it to calculate the sum and the product of two integers. The {@code BinaryOperator} interface requires a method
 * that takes two input values of the same type and produces an output of the same type.
 * </p>
 *
 * <p>
 * This example illustrates how to use {@code BinaryOperator} to perform operations that involve two inputs of the same
 * type and produce a result of the same type. It is useful for scenarios where you need to apply an operation to two
 * values of the same type and return a result of the same type.
 * </p>
 */
public class BinaryOperatorExample {

    public static void main(String[] args) {
        // Define a BinaryOperator that calculates the sum of two integers
        BinaryOperator<Integer> sumOperator = Integer::sum;

        // Use the BinaryOperator to calculate and print the sum and product of two integers
        int sum =  sumOperator.apply(5, 3);
        System.out.println("Sum: " +sum);
    }
}
