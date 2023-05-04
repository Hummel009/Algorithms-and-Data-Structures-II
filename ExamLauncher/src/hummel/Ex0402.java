package hummel;

import java.util.Scanner;

public class Ex0402 {
	public static Scanner scanner = new Scanner(System.in);

	public static void launch() {
		int maxNumber = scanner.nextInt();
		int numberOfEqualities = scanner.nextInt();
		int numberOfInequalities = scanner.nextInt();

		Set set = new Set(maxNumber);

		int result = 1;
		for (int i = 0; i < numberOfEqualities; i++) {
			set.union(scanner.nextInt() - 1, scanner.nextInt() - 1);
		}

		for (int i = 0; i < numberOfInequalities; i++) {
			if (set.check(scanner.nextInt() - 1, scanner.nextInt() - 1)) {
				result = 0;
				break;
			}
		}
		System.out.println(result);
	}

	public static class Set {
		public int[] setArray;

		public Set(int size) {
			setArray = new int[size];
			for (int i = 0; i < size; i++) {
				setArray[i] = i;
			}
		}

		public boolean check(int left, int right) {
			return setArray[find(left)] == setArray[find(right)];
		}

		public int find(int i) {
			if (i != setArray[i]) {
				setArray[i] = find(setArray[i]);
			}
			return setArray[i];
		}

		public void union(int destination, int source) {
			int destinationID = find(destination);
			int sourceID = find(source);

			setArray[sourceID] = destinationID;
		}
	}
}
