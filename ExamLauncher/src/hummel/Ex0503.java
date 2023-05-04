package hummel;

import java.io.*;
import java.util.*;

public class Ex0503 {
	public static Scanner scanner = new Scanner(System.in);
	public static short DIVIDER = 10_007;
	public static short BASE = 47;
	public static short STEPS = 6;

	public static int subStringHashCode;
	public static int patternLength;

	public static int[] powers;

	public static void fillPowers() {
		powers = new int[patternLength + 1];

		powers[0] = 1;
		powers[1] = BASE;
		if (patternLength >= 3) {
			for (int power = 2; power <= patternLength - 1; power++) {
				powers[power] = powers[power - 1] * BASE % DIVIDER;
			}
		}
	}

	public static int hashCode(char[] pattern) {
		int hashCode = 0;
		int power = 0;
		for (char ch : pattern) {
			hashCode = ((hashCode + ch * powers[power]) % DIVIDER + DIVIDER) % DIVIDER;
			power++;
		}

		return hashCode;
	}

	public static int hashCode(char[] text, int i) {
		int hashCode = 0;

		if (i != text.length - patternLength) {
			hashCode = (subStringHashCode - text[i + patternLength] * powers[patternLength - 1] % DIVIDER + DIVIDER) % DIVIDER;
			hashCode = (hashCode * BASE + text[i]) % DIVIDER;
		} else {
			for (int power = 0, pos = i; pos < i + patternLength; pos++, power++) {
				hashCode = (hashCode + text[pos] * powers[power] % DIVIDER) % DIVIDER;
			}
		}

		return hashCode;
	}

	public static void launch() {
		char[] pattern = scanner.next().toCharArray();
		char[] text = scanner.next().toCharArray();

		patternLength = pattern.length;
		fillPowers();

		int patternHashCode = hashCode(pattern);

		LinkedList<Integer> matches = new LinkedList<>();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = text.length - pattern.length; i >= 0; i--) {
			subStringHashCode = hashCode(text, i);

			if (patternHashCode == subStringHashCode) {
				boolean equals = true;

				for (int pLeft = 0, pRight = patternLength - 1, tLeft = i, tRight = i + pRight, steps = 0; tLeft < tRight && steps <= STEPS; pLeft++, tLeft++, pRight--, tRight--, steps++) {
					if (pattern[pLeft] != text[tLeft] || pattern[pRight] != text[tRight]) {
						equals = false;
						break;
					}
				}

				if (equals) {
					matches.addFirst(i);
				}
			}
		}

		for (Integer match : matches) {
			try {
				writer.write(String.format("%s ", match.toString()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
