package hummel;

import java.util.Scanner;

public class Ex0501 {
	public static Scanner scanner = new Scanner(System.in);

	public static void launch() {
		int operationCount = scanner.nextInt();

		String[] table = new String[10000000];

		for (int i = 0; i < operationCount; i++) {
			String operation = scanner.next();
			int number = scanner.nextInt();
			if (operation.startsWith("a")) {
				table[number] = scanner.next();
			} else if (operation.startsWith("f")) {
				System.out.println(table[number] == null ? "not found" : table[number]);
			} else {
				table[number] = null;
			}
		}
	}
}
