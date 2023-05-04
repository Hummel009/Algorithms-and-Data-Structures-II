package hummel;

import java.util.Scanner;

public class Ex0205 {
	public static Scanner scanner = new Scanner(System.in);

	public static int getMaxValueIndex(int[] values, int startPos, int endPos) {
		int maxValueIndex = startPos;
		for (int i = startPos; i <= endPos; i++) {
			maxValueIndex = values[i] > values[maxValueIndex] ? i : maxValueIndex;
		}
		return maxValueIndex;
	}

	public static void launch() {
		int valuesCount = scanner.nextInt();
		int[] values = new int[valuesCount];
		for (int i = 0; i < valuesCount; i++) {
			values[i] = scanner.nextInt();
		}
		int windowSize = scanner.nextInt();

		if (valuesCount == windowSize) {
			System.out.println(values[getMaxValueIndex(values, 0, values.length - 1)]);
		} else if (windowSize == 1) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int element : values) {
				stringBuilder.append(element);
				stringBuilder.append(" ");
			}
			System.out.println(stringBuilder);
		} else {
			int left = 0;
			int right = windowSize - 1;
			int maxValueIndex = getMaxValueIndex(values, left, right);

			StringBuilder stringBuilder = new StringBuilder();
			while (right < values.length) {
				if (left > maxValueIndex) {
					maxValueIndex = getMaxValueIndex(values, left, right);
				}

				if (values[right] > values[maxValueIndex]) {
					maxValueIndex = right;
				}

				stringBuilder.append(values[maxValueIndex]);
				stringBuilder.append(" ");

				left++;
				right++;
			}

			System.out.println(stringBuilder);
		}
	}
}
