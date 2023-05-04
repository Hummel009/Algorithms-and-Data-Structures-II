package hummel;

import java.util.*;

public class Ex0604 {
	public static Scanner scan = new Scanner(System.in);

	public static void launch() {
		OnlineSet set = new OnlineSet();

		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			String operation = scan.next();
			switch (operation) {
			case "+":
				int addNum = scan.nextInt();
				set.add(addNum);
				break;
			case "-":
				int removeNum = scan.nextInt();
				set.remove(removeNum);
				break;
			case "?":
				int queryNum = scan.nextInt();
				if (set.contains(queryNum)) {
					System.out.println("Found");
				} else {
					System.out.println("Not found");
				}
				break;
			case "s":
				int l = scan.nextInt();
				int r = scan.nextInt();
				System.out.println(set.sum(l, r));
				break;
			default:
				System.out.println("Invalid operation");
				break;
			}
		}
	}

	public static class OnlineSet {
		private final HashSet<Integer> set;
		private long lastSum;

		public OnlineSet() {
			set = new HashSet<>();
			lastSum = 0;
		}

		public void add(int i) {
			int f = (int) ((i + lastSum) % 1000000001);
			set.add(f);
		}

		public boolean contains(int i) {
			int f = (int) ((i + lastSum) % 1000000001);
			return set.contains(f);
		}

		public void remove(int i) {
			int f = (int) ((i + lastSum) % 1000000001);
			set.remove(f);
		}

		public long sum(int l, int r) {
			int f_l = (int) ((l + lastSum) % 1000000001);
			int f_r = (int) ((r + lastSum) % 1000000001);
			long sum = 0;
			for (int i = f_l; i <= f_r; i++) {
				if (set.contains(i)) {
					sum += i;
				}
			}
			lastSum += sum;
			return sum;
		}
	}
}