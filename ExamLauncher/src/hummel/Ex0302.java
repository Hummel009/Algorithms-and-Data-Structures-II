package hummel;

import java.util.Scanner;

public class Ex0302 {
	public static Scanner scanner = new Scanner(System.in);

	public static void launch() {
		int amogus = scanner.nextInt();
		Heap heap = new Heap(amogus);
		int processesCount = scanner.nextInt();
		for (int i = 0; i < processesCount; i++) {
			Processor firstFree = heap.getFirstFree();
			System.out.printf("%s %s%n", firstFree.number, firstFree.time);
			long newTime = scanner.nextLong();
			if (newTime != 0) {
				heap.changeTime(newTime);
			}

		}
	}

	public static class Heap {
		public Processor[] processors;
		public int size;

		public Heap(int size) {
			this.size = size;
			processors = new Processor[size];
			for (int i = 0; i < size; i++) {
				processors[i] = new Processor(i, 0);
			}
		}

		public void changeTime(long newTime) {
			processors[0].time += newTime;
			siftDown(0);
		}

		public Processor getFirstFree() {
			return processors[0];
		}

		public void siftDown(int index) {
			int smallestIndex;
			Processor top = processors[index];
			while (index < size / 2) {
				int leftChildIndex = 2 * index + 1;
				int rightChildIndex = leftChildIndex + 1;

				if (rightChildIndex >= size) {
					smallestIndex = processors[leftChildIndex].time > processors[index].time ? index : leftChildIndex;
				} else if (processors[leftChildIndex].time > processors[rightChildIndex].time) {
					smallestIndex = rightChildIndex;
				} else if (processors[leftChildIndex].time == processors[rightChildIndex].time) {
					smallestIndex = processors[leftChildIndex].number > processors[rightChildIndex].number ? rightChildIndex : leftChildIndex;
				} else {
					smallestIndex = leftChildIndex;
				}

				if (top.time < processors[smallestIndex].time || top.time == processors[smallestIndex].time && top.number <= processors[smallestIndex].number) {
					break;
				}

				processors[index] = processors[smallestIndex];
				index = smallestIndex;
				processors[index] = top;
			}
		}
	}

	public static class Processor {
		public int number;
		public long time;

		public Processor(int number, long time) {
			this.number = number;
			this.time = time;
		}
	}
}
