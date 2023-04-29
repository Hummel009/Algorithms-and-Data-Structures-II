package hummel;

import java.util.Scanner;

public class Ex0301 {
	public static int size;
	public static int[] heap;
	public static int swapCounter;
	public static StringBuilder stringBuilder = new StringBuilder();
	public static Scanner scanner = new Scanner(System.in);

	public static void fixHeap() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			siftDown(i);
		}
	}

	public static void launch() {
		size = scanner.nextInt();
		heap = new int[size];
		for (int i = 0; i < size; i++) {
			heap[i] = scanner.nextInt();
		}
		fixHeap();

		System.out.println(swapCounter);
		if (swapCounter != 0) {
			System.out.println(stringBuilder.toString());
		}
	}

	public static void siftDown(int index) {
		int smallestIndex;
		int top = heap[index];
		while (index < size / 2) {
			int leftChildIndex = 2 * index + 1;
			int rightChildIndex = leftChildIndex + 1;

			if (rightChildIndex >= size) {
				smallestIndex = heap[leftChildIndex] > heap[index] ? index : leftChildIndex;
			} else if (heap[leftChildIndex] > heap[rightChildIndex]) {
				smallestIndex = rightChildIndex;
			} else {
				smallestIndex = leftChildIndex;
			}

			if (top <= heap[smallestIndex]) {
				break;
			}

			swapCounter++;
			stringBuilder.append(String.format("%s %s %n", index, smallestIndex));
			heap[index] = heap[smallestIndex];
			index = smallestIndex;
			heap[index] = top;
		}
	}
}