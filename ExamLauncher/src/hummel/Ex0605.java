package hummel;

import java.util.Scanner;

public class Ex0605 {
	public static Scanner scanner = new Scanner(System.in);

	public static void launch() {
		System.out.println("Enter text:");
		String text = scanner.nextLine();
		System.out.println("Enter args count:");
		int argsCount = scanner.nextInt();
		scanner.nextLine();
		Rope rope = new Rope(text, argsCount);
		for (int i = 0; i < argsCount; i++) {
			String arg = scanner.nextLine();
			int from = Integer.parseInt(arg.split(" ")[0]);
			int until = Integer.parseInt(arg.split(" ")[1]);
			int instead = Integer.parseInt(arg.split(" ")[2]);
			String res = rope.ropeText(from, until, instead);
			System.out.println(res);
		}
	}

	public static class Rope {
		public String text;
		public int argsCount;

		public Rope(String input, int argsCount) {
			text = input;
			this.argsCount = argsCount;
		}

		public String ropeText(int from, int until, int instead) {
			StringBuilder tmp = new StringBuilder();
			for (int i = from; i <= until; i++) {
				tmp.append(text.charAt(i));
			}
			text = text.replaceFirst(tmp.toString(), "");
			StringBuilder textSB = new StringBuilder(text);
			textSB.insert(instead, tmp);
			text = textSB.toString();

			return text;
		}
	}
}