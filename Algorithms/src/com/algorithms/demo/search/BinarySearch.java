package com.algorithms.demo.search;

import com.algorithms.demo.utils.ArrayUtils;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] numbers = ArrayUtils.generateSortedUniqueRandomIntArray(10, 30);
		ArrayUtils.printArrayWithMessage("Sorted Array: ", numbers);
		binarySearch(numbers, 10);
	}

	private static void binarySearch(int[] numbers, int searchVal) {
		System.out.printf("Element to be searched: %d", searchVal);
		int start = 0;
		int end = numbers.length - 1;
		boolean found = false;

		while (!found && start <= end) {
			int midIndex = (start + end) / 2;
			if (searchVal > numbers[midIndex]) {
				start = midIndex + 1;
			} 
			else if (searchVal < numbers[midIndex]) {
				end = midIndex - 1;
			} 
			else {
				found = true;
				System.out.printf("\nFound %d at index: %d\n", searchVal, midIndex);
				return;
			}
		}
		System.out.println("Element not found");
	}
}
