package hummel;

import java.util.Scanner;

public class Ex0202 {
	public static Scanner scanner = new Scanner(System.in);

	public static int heightCounter(int[] tree, int index) {
		int pValue = tree[index];
		if (pValue == -1) {
			return 1;
		}
		return 1 + heightCounter(tree, pValue);
	}

	public static void launch() {
		int length = scanner.nextInt();
		int[] tree = new int[length];
		for (int index = 0; index < length; index++) {
			tree[index] = scanner.nextInt();
		}
		int height = 1;
		for (int index = 0; index < tree.length; index++) {
			height = Math.max(height, heightCounter(tree, index));
		}
		System.out.println(height);
	}
}
