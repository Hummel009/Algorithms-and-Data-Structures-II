package hummel;

import java.util.Scanner;

public class Ex0603 {
	public static Scanner scanner = new Scanner(System.in);
	public static Node[] nodes;

	public static boolean isTreeValid(int index, Range range) {
		if (index == -1) {
			return true;
		}

		range.left = nodes[index].value;
		range.right = nodes[index].value;

		if (nodes[index].left != -1) {
			Range lRange = new Range(0, 0);
			if (!isTreeValid(nodes[index].left, lRange) || lRange.right > nodes[index].value) {
				return false;
			}

			range.left = lRange.left;
		}

		if (nodes[index].right != -1) {
			Range rRange = new Range(0, 0);
			if (!isTreeValid(nodes[index].right, rRange) || rRange.left <= nodes[index].value) {
				return false;
			}

			range.right = rRange.right;
		}

		return true;
	}

	public static void launch() {
		int vertexCount = scanner.nextInt();
		if (vertexCount == 0) {
			System.out.println("CORRECT");
		} else {
			nodes = new Node[vertexCount];
			for (int i = 0; i < vertexCount; i++) {
				nodes[i] = new Node(scanner.nextLong(), scanner.nextInt(), scanner.nextInt());
			}

			Range range = new Range(0, 0);

			System.out.println(isTreeValid(0, range) ? "CORRECT" : "INCORRECT");
		}
	}

	public static class Node {
		public long value;
		public int left;
		public int right;

		public Node(long value, int left, int right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	public static class Range {
		public long left;
		public long right;

		public Range(long left, long right) {
			this.left = left;
			this.right = right;
		}
	}
}
