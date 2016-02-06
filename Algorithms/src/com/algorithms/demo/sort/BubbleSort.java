package com.algorithms.demo.sort;

import com.algorithms.demo.utils.ArrayUtils;

public class BubbleSort {

	private enum SortOrder {
		ASCENDING, DESCENDING;
	}

	public static void main(String[] args) {
		int[] numbers = ArrayUtils.generateRandomIntArray(10,30);
		ArrayUtils.printArrayWithMessage("Unsorted List: ", numbers);

		bubbleSort(numbers, SortOrder.ASCENDING);
		ArrayUtils.printArrayWithMessage("Sorted Ascending Order: ", numbers);

		bubbleSort(numbers, SortOrder.DESCENDING);
		ArrayUtils.printArrayWithMessage("Sorted Descending Order: ", numbers);
	}

	/**
	 * Finds the maximum or minimum number or bubbles it up to the either end of
	 * the array based on the order in every iteration. For instance if the sort
	 * order is ascending i.e natural order then, the adjacent numbers are
	 * compared and if the number on the right side is lower than the number on
	 * the left side then they are swapped and iteration.
	 */
	private static void bubbleSort(int[] numbers, SortOrder order) {
		if (order == null)
			return;

		switch (order) {
		case ASCENDING: {
			for (int i = numbers.length - 1; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					if (numbers[j] > numbers[j + 1]) {
						ArrayUtils.swapValues(j, j + 1, numbers);
					}
				}
			}
			break;
		}

		case DESCENDING: {
			for (int i = numbers.length - 1; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					if (numbers[j] < numbers[j + 1]) {
						ArrayUtils.swapValues(j, j + 1, numbers);
					}
				}
			}
			break;
		}
		}
	}
}
