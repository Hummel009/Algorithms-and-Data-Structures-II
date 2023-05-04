package hummel;

import java.util.Scanner;

public class Ex0401 {
	public static Scanner scanner = new Scanner(System.in);

	public static void launch() {
		int tablesCount = scanner.nextInt();
		int requestsCount = scanner.nextInt();
		Set set = new Set(tablesCount);
		for (int i = 0; i < tablesCount; i++) {
			set.initSet(scanner.nextInt(), i);
		}

		for (int i = 0; i < requestsCount; i++) {
			set.union(scanner.nextInt() - 1, scanner.nextInt() - 1);
			System.out.println(set.maxRank);
		}
	}

	public static class Set {
		public int[] rank;
		public int[] setArray;
		public int maxRank;

		public Set(int tablesCount) {
			setArray = new int[tablesCount];
			rank = new int[tablesCount];
		}

		public int find(int i) {
			if (i != setArray[i]) {
				setArray[i] = find(setArray[i]);
			}
			return setArray[i];
		}

		public void initSet(int entryCount, int position) {
			setArray[position] = position;
			rank[position] = entryCount;
			maxRank = Math.max(entryCount, maxRank);
		}

		public void union(int destination, int source) {
			int destinationID = find(destination);
			int sourceID = find(source);

			if (destinationID == sourceID) {
				return;
			}

			setArray[sourceID] = destinationID;
			rank[destinationID] += rank[sourceID];
			maxRank = Math.max(rank[destinationID], maxRank);
		}
	}
}
