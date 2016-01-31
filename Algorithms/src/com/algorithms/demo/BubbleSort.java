package com.algorithms.demo;

public class BubbleSort {
	
	private int[] numbers = { 10, 9, 8, 6, 5, 4, 3, 2, 1, 7 };

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();

		System.out.println("\nUnsorted Array");
		bubbleSort.printArray();

		System.out.println("\n\nSorted Array: Ascending");
		bubbleSort.bubbleSortAscending();
		bubbleSort.printArray();

		System.out.println("\n\nSorted Array: Descending");
		bubbleSort.bubbleSortDescending();
		bubbleSort.printArray();
	}

	private void printArray() {
		for (int i : numbers) {
			System.out.print(i + " ");
		}
	}

	private void bubbleSortAscending() {
		for (int i = numbers.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					swapNumbers(j, j + 1);
				}
			}
		}
	}

	private void bubbleSortDescending() {
		for (int i = numbers.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (numbers[j] < numbers[j + 1]) {
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
}
