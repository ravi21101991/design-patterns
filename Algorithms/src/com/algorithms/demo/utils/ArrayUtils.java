package com.algorithms.demo.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ArrayUtils {

	/**
	 * Prints the array elements of given int[] with given String message
	 */
	public static void printArrayWithMessage(String message, int[] numbers) {
		System.out.println(message);
		for (int i : numbers) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/**
	 * Swaps the values for given indices and given int[] numbers
	 */
	public static void swapValues(int index1, int index2, int[] numbers) {
		int temp = numbers[index1];
		numbers[index1] = numbers[index2];
		numbers[index2] = temp;
	}

	/**
	 * Generates an int[] with random number with given size and bound value
	 */
	public static int[] generateRandomIntArray(int size, int bound) {
		int[] numbers = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			numbers[i] = random.nextInt(bound);
		}

		return numbers;
	}

	/**
	 * Generates an int[] with unique random number with given size and bound
	 * value. The values in int[] are sorted in natural order.Also value of size
	 * must be equal to or less than bound value.
	 */
	public static int[] generateSortedUniqueRandomIntArray(int size, int bound) {

		if (size > bound) {
			throw new IllegalArgumentException(
					"The value of size must be equal or less than bound value");
		}
		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		Random random = new Random();
		while (true) {
			uniqueNumbers.add(random.nextInt(bound));
			if (size == uniqueNumbers.size()) {
				break;
			}
		}

		Object[] objArr = uniqueNumbers.toArray();
		int[] numbers = new int[objArr.length];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (Integer) objArr[i];
		}

		Arrays.sort(numbers);
		return numbers;
	}
}
