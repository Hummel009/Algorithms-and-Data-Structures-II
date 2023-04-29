package hummel;

import java.util.*;

public class Ex0203 {
	public static int time;
	public static int bufferSize;
	public static Deque<Package> buffer;
	public static Scanner scanner = new Scanner(System.in);

	public static void launch() {
		bufferSize = scanner.nextInt();
		buffer = new ArrayDeque<>(bufferSize);
		int packageCount = scanner.nextInt();

		if (packageCount == 0) {
			System.out.println();
		} else if (packageCount == 1) {
			System.out.println(scanner.nextInt());
		} else {
			for (int i = 0; i < packageCount; i++) {
				process(new Package(scanner.nextInt(), scanner.nextInt()));
			}
			scanner.close();
		}
	}

	public static void process(Package pack) {
		if (buffer.size() < bufferSize) {
			System.out.println(Math.max(time, pack.average));

			if (pack.average >= time) {
				time = pack.getEndTime();
			} else {
				time += pack.duration;
			}
			pack.end = time;
			buffer.add(pack);
		} else if (pack.average >= buffer.getFirst().end) {
			System.out.println(Math.max(time, pack.average));
			if (time > buffer.getLast().end) {
				time += pack.duration;
			} else {
				time = buffer.getLast().end + pack.duration;
			}
			buffer.removeFirst();
			pack.end = time;
			buffer.add(pack);
		} else {
			System.out.println("-1");
		}
	}

	public static class Package {
		public int average;
		public int duration;
		public int end;

		public Package(int average, int duration) {
			this.average = average;
			this.duration = duration;
		}

		public int getEndTime() {
			return average + duration;
		}
	}
}