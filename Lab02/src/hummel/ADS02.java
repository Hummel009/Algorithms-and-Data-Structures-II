package hummel;

import java.util.*;

public class ADS02 {
	public static Scanner input10 = new Scanner(System.in);
	public static Scanner input11 = new Scanner(System.in);
	public static Scanner input12 = new Scanner(System.in);
	public static Scanner input13 = new Scanner(System.in);
	public static Scanner input21 = new Scanner(System.in);
	public static List<Content> list = new ArrayList<>();
	public static Map<String, Content> map = new HashMap<>();

	private static void addObject() {
		ArrayList<Integer> ids1 = new ArrayList<>();
		ids1.add(17);
		ids1.add(81);
		ArrayList<Integer> ids2 = new ArrayList<>();
		ids2.add(16);
		ids2.add(72);
		ids2.add(32);
		ids2.add(39);
		ArrayList<Integer> ids3 = new ArrayList<>();
		ids3.add(14);
		ids3.add(51);
		ids3.add(36);
		ArrayList<Integer> ids11 = new ArrayList<>();
		ids11.add(73);
		ids11.add(86);
		ArrayList<Integer> ids21 = new ArrayList<>();
		ids21.add(11);
		ids21.add(20);
		ids21.add(33);
		ids21.add(98);
		ArrayList<Integer> ids22 = new ArrayList<>();
		ids22.add(21);
		ids22.add(27);
		ids22.add(23);
		ids22.add(79);
		ArrayList<Integer> ids32 = new ArrayList<>();
		ids32.add(45);
		ids32.add(15);
		ids32.add(68);
		ArrayList<Integer> ids31 = new ArrayList<>();
		ids31.add(14);
		ids31.add(56);
		ids31.add(69);

		ArrayList<Content> conts11 = new ArrayList<>();
		conts11.add(new Content("b", ids11));

		ArrayList<Content> conts21 = new ArrayList<>();
		conts21.add(new Content("y", ids21));
		conts21.add(new Content("b", ids22));

		ArrayList<Content> conts32 = new ArrayList<>();
		conts32.add(new Content("o", ids32));
		ArrayList<Content> conts31 = new ArrayList<>();
		conts31.add(new Content("j", ids31, conts32));

		Content prev1 = new Content("a", ids1, conts11);
		Content prev2 = new Content("x", ids2, conts21);
		Content prev3 = new Content("z", ids3, conts31);
		list.add(prev1);
		list.add(prev2);
		list.add(prev3);
		map.put("a", prev1);
		map.put("x", prev2);
		map.put("z", prev3);
		showObjects();
	}

	private static void editObject(Content content) {
		content.contentIds.clear();
		content.contentSubs.clear();
		System.out.println("Enter the new ids of the old object.");
		while (true) {
			int read = input12.nextInt();
			if (read == 0) {
				break;
			}
			content.contentIds.add(read);
		}
		Collections.sort(content.contentIds);

		while (true) {
			System.out.println("Has sub-content?");
			boolean read = input13.nextBoolean();
			if (!read) {
				break;
			}
			ArrayList<Integer> temp = new ArrayList<>();
			System.out.println("Enter the name:");
			String name = input21.nextLine();
			System.out.println("Enter the new ids:");
			while (true) {
				int reads = input12.nextInt();
				if (reads == 0) {
					break;
				}
				temp.add(reads);
			}
			Collections.sort(temp);
			Content prev = new Content(name, temp);
			content.contentSubs.add(prev);
		}
	}

	private static void editObjects() {
		System.out.println("Enter the name of the old object.");
		String name = input11.nextLine();
		Content cont = map.get(name);
		if (cont != null) {
			editObject(cont);
		} else {
			System.out.println("Wrong! Enter the sub-object name then.");
			String namesub = input13.nextLine();
			for (Content c : map.values()) {
				for (Content sub : c.contentSubs) {
					if (c.contentSubs != null && sub.contentName.equals(namesub)) {
						editObject(c);
					}
				}
			}
		}
		showObjects();
	}

	private static void findObject() {
		System.out.println("Enter the name of the old object.");
		String name = input11.nextLine();
		Content cont = map.get(name);
		if (cont != null) {
			System.out.println(cont);
		} else {
			System.out.println("Wrong! Enter the sub-object name then.");
			String namesub = input13.nextLine();
			for (Content c : map.values()) {
				for (Content sub : c.contentSubs) {
					if (c.contentSubs != null && sub.contentName.equals(namesub)) {
						System.out.println(c);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		printOptions();
		sus: while (true) {
			int opt = input10.nextInt();
			switch (opt) {
			case 1:
				addObject();
				break;
			case 2:
				editObjects();
				break;
			case 3:
				removeObjects();
				break;
			case 4:
				showObjects();
				break;
			case 5:
				findObject();
				break;
			case 6:
				sortName();
				break;
			case 7:
				sortContent();
				break;
			case 8:
				break sus;
			}
		}
	}

	public static void printOptions() {
		System.out.println();
		System.out.println("====================");
		System.out.println();
		System.out.println("1. Add objects.");
		System.out.println("2. Edit object.");
		System.out.println("3. Remove objects.");
		System.out.println("4. Show objects.");
		System.out.println("5. Find objects.");
		System.out.println("6. Sort by name.");
		System.out.println("7. Sort by content.");
		System.out.println("8. Close.");
		System.out.println();
		System.out.println("====================");
		System.out.println();
	}

	private static void removeObjects() {
		System.out.println("Enter the name of the old object.");
		String name = input11.nextLine();
		Content cont = map.get(name);
		if (cont != null) {
			list.remove(cont);
			map.remove(cont.contentName);
		} else {
			System.out.println("Wrong! Enter the sub-object name then.");
			String namesub = input13.nextLine();
			for (Content c : map.values()) {
				for (Content sub : c.contentSubs) {
					if (c.contentSubs != null && sub.contentName.equals(namesub)) {
						list.remove(c);
					}
				}
			}
		}
		showObjects();
	}

	private static void showObjects() {
		for (Content cont : list) {
			System.out.println(cont.toString());
		}
	}

	private static void sortContent() {
		Comparator<Content> comparator = Comparator.comparing(o1 -> o1.contentIds.get(0));
		for (Content c : list) {
			if (c.contentSubs != null) {
				c.contentSubs.sort(comparator);
			}
		}
		list.sort(comparator);
		showObjects();
	}

	private static void sortName() {
		Comparator<Content> comparator = Comparator.comparing(o1 -> o1.contentName);
		list.sort(comparator);
		for (Content c : list) {
			if (c.contentSubs != null) {
				c.contentSubs.sort(comparator);
			}
		}
		showObjects();
	}

	public static class Content {
		public List<Content> contentSubs;
		public List<Integer> contentIds;
		public String contentName;

		public Content(String fName, List<Integer> fIds) {
			contentName = fName;
			contentIds = fIds;
			contentSubs = null;
		}

		public Content(String fName, List<Integer> fIds, List<Content> fSub) {
			contentName = fName;
			contentIds = fIds;
			contentSubs = fSub;
		}

		@Override
		public String toString() {
			if (contentSubs == null) {
				return contentName + ": " + contentIds.toString() + ", sub does not exist.";
			}
			StringBuilder s = new StringBuilder().append(contentName).append(": ").append(contentIds.toString()).append(", subs:\n");
			for (Content c : contentSubs) {
				s.append(c.toString()).append("\n");
			}
			return s.toString();
		}
	}
}