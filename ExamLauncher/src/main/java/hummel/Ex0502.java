package hummel;

import java.util.*;

public class Ex0502 {
	public static Scanner scanner = new Scanner(System.in);
	public static int DIVIDER = 1_000_000_007;
	public static int BASE = 263;

	public static void launch() {
		HashTable hashTable = new HashTable(scanner.nextInt());
		int operationsCount = scanner.nextInt();
		for (int i = 0; i < operationsCount; i++) {
			String operation = scanner.next();
			if (operation.startsWith("a")) {
				hashTable.add(scanner.next());
			} else if (operation.startsWith("c")) {
				System.out.println(hashTable.getValues(scanner.nextInt()));
			} else if (operation.startsWith("f")) {
				System.out.println(hashTable.find(scanner.next()));
			} else {
				hashTable.delete(scanner.next());
			}
		}
	}

	public static class HashTable {
		public Words[] table;

		public HashTable(int size) {
			table = new Words[size];
		}

		public void add(String string) {
			int hashCode = hashCode(string);
			if (table[hashCode] == null) {
				table[hashCode] = new Words();
			}
			table[hashCode].add(string);
		}

		public void delete(String string) {
			int hashCode = hashCode(string);
			if (table[hashCode] != null && !table[hashCode].isEmpty()) {
				table[hashCode].delete(string);
			}
		}

		public String find(String string) {
			int hashCode = hashCode(string);
			if (table[hashCode] == null || table[hashCode].isEmpty()) {
				return "no";
			}
			if (table[hashCode].contains(string)) {
				return "yes";
			}
			return "no";
		}

		public String getValues(int hashCode) {
			if (table[hashCode] == null || table[hashCode].isEmpty()) {
				return "";
			}
			return table[hashCode].getValues();
		}

		public int hashCode(String string) {
			long hashCode = 0;
			int i = 0;
			for (char ch : string.toCharArray()) {
				hashCode = ((hashCode + ch * pow(i)) % DIVIDER + DIVIDER) % DIVIDER;
				i++;
			}

			return (int) (hashCode % table.length);
		}

		public long pow(int pow) {
			long result = 1;
			for (int i = 0; i < pow; i++) {
				result = result * BASE % DIVIDER;
			}

			return result;
		}

		public static class Words {
			public List<String> wordsList;

			public Words() {
				wordsList = new LinkedList<>();
			}

			public void add(String string) {
				if (!contains(string)) {
					((LinkedList<String>) wordsList).addFirst(string);
				}
			}

			public boolean contains(String string) {
				boolean contains = false;
				for (String str : wordsList) {
					if (str.equals(string)) {
						contains = true;
						break;
					}
				}
				return contains;
			}

			public void delete(String string) {
				Iterator<String> iterator = wordsList.iterator();
				while (iterator.hasNext()) {
					if (iterator.next().equals(string)) {
						iterator.remove();
						break;
					}
				}
			}

			public String getValues() {
				StringBuilder stringBuilder = new StringBuilder();
				for (String aWordsList : wordsList) {
					stringBuilder.append(aWordsList);
					stringBuilder.append(" ");
				}

				return stringBuilder.toString();
			}

			public boolean isEmpty() {
				return wordsList.isEmpty();
			}
		}
	}
}
