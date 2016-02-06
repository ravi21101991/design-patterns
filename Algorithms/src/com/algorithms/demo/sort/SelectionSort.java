package com.algorithms.demo.sort;

import com.algorithms.demo.utils.ArrayUtils;

/**
 * Start looping through the entire list of elements and find a minimum value
 * and place it into first index and then repeat the task for next position from
 * left to right until the entire list is in sorted order. Selection sort takes
 * two sub lists: the left sublist which is entirely empty in the beginning and
 * second sub list which is full. As the loop is iterated the right sublist gets
 * empty and left gets full thus giving sorted list. For instance following is
 * the unsorted list:
 * 
 * Iteration 	Array 				Left Sublist(Sorted) 	Right Sublist(Unsorted) 
 * 0			[2, 6, 7, 3, 1]		[]						[2, 6, 7, 3, 1]		
 * 1			[2, 6, 7, 3, 1]		[1]						[2, 6, 7, 3]
 * 2			[2, 6, 7, 3, 1]		[1, 2]					[6, 7, 3]
 * 3			[2, 6, 7, 3, 1]		[1, 2, 3]				[6, 7]
 * 4			[2, 6, 7, 3, 1]		[1, 2, 3, 6]			[7]
 * 5			[2, 6, 7, 3, 1]		[1, 2, 3, 6, 7]			[]
 *
 */
public class SelectionSort {
	public static void main(String[] args) {
		int[] numbers = ArrayUtils.generateRandomIntArray(10,30);
		ArrayUtils.printArrayWithMessage("Unsorted Array: ", numbers);

		selectionSort(numbers);
		ArrayUtils.printArrayWithMessage("Sorterd Array: ", numbers);
	}

	private static void selectionSort(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			int minimum = i;
			for (int j = i; j < numbers.length; j++) {
				if (numbers[j] < numbers[minimum]) {
					minimum = j;
				}
			}
			ArrayUtils.swapValues(i, minimum, numbers);
		}
	}
}
