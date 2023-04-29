package hummel;

import java.util.Scanner;

public class Ex0601 {
	public static Node[] nodes;
	public static StringBuilder inOrder = new StringBuilder();
	public static StringBuilder preOrder = new StringBuilder();
	public static StringBuilder postOrder = new StringBuilder();
	public static Scanner scanner = new Scanner(System.in);

	public static void launch() {
		int vertexCount = scanner.nextInt();
		nodes = new Node[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			nodes[i] = new Node(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
		}

		walk(0);
		System.out.println(inOrder.toString());
		System.out.println(preOrder.toString());
		System.out.println(postOrder.toString());
	}

	public static void walk(int index) {
		if (index == -1) {
			return;
		}

		preOrder.append(nodes[index].value);
		preOrder.append(" ");

		walk(nodes[index].left);

		inOrder.append(nodes[index].value);
		inOrder.append(" ");

		walk(nodes[index].right);

		postOrder.append(nodes[index].value);
		postOrder.append(" ");
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
