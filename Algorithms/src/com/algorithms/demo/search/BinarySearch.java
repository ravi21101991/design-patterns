package com.algorithms.demo.search;

public class BinarySearch {

	private int[] numbers = { 10, 9, 8, 6, 5, 4, 3, 2, 1, 7 };

	private void sortAscending() {
		for (int i = numbers.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					swapNumbers(j, j + 1);
				}
			}
		}
	}

	private void swapNumbers(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public int binarySearch(int value, int[] numbers) {
		int lowIndex = 0;
		int highIndex = numbers.length - 1;
		boolean found = false;
		int result = -1;

		if (value > numbers[highIndex] || value < numbers[lowIndex]) {
			return result;
		}

		while (!found) {
			int middleIndex = (lowIndex + highIndex) / 2;
			if (value > numbers[middleIndex])
				lowIndex = middleIndex + 1;
			else if (value < middleIndex)
				highIndex = middleIndex - 1;
			else {
				result = middleIndex;
				found = true;
			}
		}
		return result;
	}

	private static void searchElement(BinarySearch binarySearch, int value) {
		binarySearch.sortAscending();
		binarySearch.printArray();
		System.out.printf("Value to be searched: %d\n", value);
		int index = binarySearch.binarySearch(value, binarySearch.numbers);
		if (index >= 0)
			System.out.printf("Found element: %d at index: %d\n", value, index);
		else
			System.out.printf("%d not found in the array", value);
	}

	private void printArray() {
		System.out.print("Array Elements:");
		for (int i : numbers) {
			System.out.printf(" %d", i);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		searchElement(new BinarySearch(), 11);
	}
}
