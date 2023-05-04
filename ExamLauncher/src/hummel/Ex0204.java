package hummel;

import java.util.*;

public class Ex0204 {
	public static Scanner scanner = new Scanner(System.in);

	public static void launch() {
		int operationCount = scanner.nextInt();

		Deque<Integer> operationStack = new ArrayDeque<>(operationCount);
		Deque<Integer> maxStack = new ArrayDeque<>(operationCount);
		for (int i = 0; i < operationCount; i++) {
			String operation = null;
			operation = scanner.next();
			if (operation.startsWith("push")) {
				int value = 0;
				value = scanner.nextInt();
				operationStack.push(value);
				maxStack.push(Math.max(maxStack.isEmpty() ? 0 : maxStack.peek(), value));
			} else if (operation.startsWith("pop")) {
				operationStack.pop();
				maxStack.pop();
			} else {
				System.out.println(maxStack.isEmpty() ? 0 : maxStack.peek());
			}
		}
	}

}