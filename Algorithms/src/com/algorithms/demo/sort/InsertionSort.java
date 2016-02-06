package com.algorithms.demo.sort;

import com.algorithms.demo.utils.ArrayUtils;

/**
 * This sort is similar to sorting the cards in a card game. Initially you have
 * a single card in your hand while dealer is distributing them. As the second
 * card comes along you sort it on the fly and decide whether it should go to
 * the left or to the right of the sorted sub array hence sorting while
 * inserting.
 * 
 */

public class InsertionSort {
	public static void main(String[] args) {
		int[] numbers = ArrayUtils.generateRandomIntArray(10,30);
		ArrayUtils.printArrayWithMessage("Unsorted Array: ", numbers);

		insertionSort(numbers);
		ArrayUtils.printArrayWithMessage("Sorted Array: ", numbers);
	}

	/**
	 * Start sorting at index 1 assuming that value of index 0 is already sorted
	 * as it is a single value. Integer i represents index 1 to length of the
	 * provided array and integer j represents values from i-1 to 0 provided
	 * that numbers[j] is greater than the value of numbers[i] represented by
	 * variable temp. The position of the values greater than the temporary
	 * number will be shifted one place to the right till the condition
	 * numbers[j] > temp holds true. Then it will break the while loop and place
	 * the temporary number at the desired location in the sorted sub list.
	 */
	private static void insertionSort(int[] numbers) {

		for (int i = 1; i < numbers.length; i++) {
			int temp = numbers[i];
			int j = i - 1;

			while (j >= 0 && numbers[j] > temp) {
				numbers[j + 1] = numbers[j];
				j--;
			}
			numbers[j + 1] = temp;
		}
	}
}
