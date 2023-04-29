package hummel;

import java.util.*;

public class Ex0201 {
	public static Scanner in = new Scanner(System.in);

	public static void launch() {
		char[] bracket = in.next().toCharArray();
		LinkedList<Character> stack = new LinkedList<>();

		int n = bracket.length;
		int unclosedBracket = 0;

		for (int i = 0; i < n; i++) {
			if (bracket[i] == '{' || bracket[i] == '(' || bracket[i] == '[') {
				if (stack.isEmpty()) {
					unclosedBracket = i + 1;
				}
				stack.push(bracket[i]);
			} else if (bracket[i] == '}' || bracket[i] == ')' || bracket[i] == ']') {
				if (!Objects.equals(stack.peek(), reverseBracket(bracket[i]))) {
					System.out.println(i + 1);
					return;
				}
				stack.pop();
			}
		}
		if (stack.isEmpty()) {
			System.out.println("Success");
		} else {
			System.out.println(unclosedBracket);
		}
	}

	public static Character reverseBracket(char c) {
		switch (c) {
		case '}':
			return '{';
		case ']':
			return '[';
		case ')':
			return '(';
		default:
			return '-';
		}
	}
}