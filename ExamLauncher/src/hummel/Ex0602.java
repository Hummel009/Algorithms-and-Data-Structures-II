package hummel;

import java.util.Scanner;

public class Ex0602 {
	public static Node[] nodes;

	public static boolean isTreeValid(int index, int leftBorder, int rightBorder) {
		if (index == -1) {
			return true;
		}

		if (nodes[index].value < leftBorder || nodes[index].value > rightBorder) {
			return false;
		}

		return isTreeValid(nodes[index].left, leftBorder, nodes[index].value) && isTreeValid(nodes[index].right, nodes[index].value, rightBorder);
	}

	public static void launch() {
		try (Scanner scanner = new Scanner(System.in)) {
			int vertexCount = scanner.nextInt();
			if (vertexCount != 0) {
				nodes = new Node[vertexCount];
				for (int i = 0; i < vertexCount; i++) {
					nodes[i] = new Node(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
				}

				System.out.println(isTreeValid(0, Integer.MIN_VALUE, Integer.MAX_VALUE) ? "CORRECT" : "INCORRECT");
			} else {
				System.out.println("CORRECT");
			}
		}
	}

	public static class Node {
		public int value;
		public int left;
		public int right;

		public Node(int value, int left, int right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
}