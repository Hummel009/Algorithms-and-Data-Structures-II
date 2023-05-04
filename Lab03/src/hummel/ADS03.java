package hummel;

import java.util.*;

public class ADS03 {
	public static Scanner scan = new Scanner(System.in);
	public Node root;
	public List<Value> list = new ArrayList<>();
	public int[] rab = new int[100];
	public int[] arb = new int[100];
	public int[] abr = new int[100];
	public int rabc;
	public int arbc;
	public int abrc;

	public ADS03() {
		root = null;
	}

	public void print() {
		System.out.println();
		System.out.println();
		print(root, "", "");
	}

	public void print(Node root, String s, String isLeft) {
		System.out.println(s + isLeft + root.value);
		s += "   ";
		if (root.left != null) {
			print(root.left, s, "L) ");
		}
		if (root.right != null) {
			print(root.right, s, "R) ");
		}
	}

	public void printABR() {
		printABR(root);
		abr[abrc] = root.value;
		abrc++;
	}

	public void printABR(Node root) {
		if (root.left != null) {
			printABR(root.left);
		}
		if (root.right != null) {
			printABR(root.right);
		}
		abr[abrc] = root.value;
		abrc++;
		System.out.print(root.value + " ");
	}

	public void printABRLinked() {
		System.out.println();
		System.out.println();
		printABRLinked(root, "", "");
	}

	public void printABRLinked(Node root, String s, String isLeft) {
		System.out.println(s + isLeft + root.value);
		s += "   ";
		if (root.left != null) {
			printABRLinked(root.left, s, "L) ");
		}
		if (root.right != null) {
			printABRLinked(root.right, s, "R) ");
		} else {
			int i;
			for (i = 0; i < abr.length; i++) {
				if (abr[i] == root.value) {
					break;
				}
			}
			System.out.println(s + "R) --> " + abr[i + 1]);
		}
	}

	public void printARB() {
		printARB(root);
		arb[arbc] = root.value;
		arbc++;
	}

	public void printARB(Node root) {
		if (root.left != null) {
			printARB(root.left);
		}
		System.out.print(root.value + " ");
		arb[arbc] = root.value;
		arbc++;
		if (root.right != null) {
			printARB(root.right);
		}
	}

	public void printARBLinked() {
		System.out.println();
		System.out.println();
		printARBLinked(root, "", "");
	}

	public void printARBLinked(Node root, String s, String isLeft) {
		System.out.println(s + isLeft + root.value);
		s += "   ";
		if (root.left != null) {
			printARBLinked(root.left, s, "L) ");
		}
		if (root.right != null) {
			printARBLinked(root.right, s, "R) ");
		} else {
			int i;
			for (i = 0; i < arb.length; i++) {
				if (arb[i] == root.value) {
					break;
				}
			}
			System.out.println(s + "R) --> " + arb[i + 1]);
		}
	}

	public void printRAB() {
		printRAB(root);
		rab[rabc] = root.value;
		rabc++;
	}

	public void printRAB(Node root) {
		System.out.print(root.value + " ");
		rab[rabc] = root.value;
		rabc++;
		if (root.left != null) {
			printRAB(root.left);
		}
		if (root.right != null) {
			printRAB(root.right);
		}
	}

	public void printRABLinked() {
		System.out.println();
		System.out.println();
		printRABLinked(root, "", "");
	}

	public void printRABLinked(Node root, String s, String isLeft) {
		System.out.println(s + isLeft + root.value);
		s += "   ";
		if (root.left != null) {
			printRABLinked(root.left, s, "L) ");
		}
		if (root.right != null) {
			printRABLinked(root.right, s, "R) ");
		} else {
			int i;
			for (i = 0; i < rab.length; i++) {
				if (rab[i] == root.value) {
					break;
				}
			}
			System.out.println(s + "R) --> " + rab[i + 1]);
		}
	}

	public void push(int value) {
		root = push(root, value);
		Value val = new Value(value);
		list.add(val);
	}

	public Node push(Node root, int key) {
		if (root == null) {
			return new Node(key);
		}
		if (key < root.value) {
			root.left = push(root.left, key);
		} else if (key > root.value) {
			root.right = push(root.right, key);
		}
		return root;
	}

	public void remove(int i) {
		root = null;
		for (int c = 0; c < 100; c++) {
			arb[c] = 0;
			abr[c] = 0;
			rab[c] = 0;
		}
		for (Value val : list) {
			if (val.value == i) {
				list.remove(val);
				break;
			}
		}
		for (Value val : list) {
			repush(val.value);
		}
	}

	public void repush(int value) {
		root = push(root, value);
	}

	public static void main(String[] args) {
		ADS03 bst = new ADS03();
		int[] arr = new int[6];
		System.out.print("ENTER NUMBERS (example: 45 10 7 12 90 50): ");
		for (int i = 0; i < 6; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.print("ENTER REMOVAL (example: 7): ");
		int rem = scan.nextInt();
		for (int i = 0; i < 6; i++) {
			bst.push(arr[i]);
		}
		System.out.print("START TREE: ");
		bst.print();
		System.out.println("\nTREE WITH RAB LINKS");
		bst.printRAB();
		bst.printRABLinked();
		System.out.println("\nTREE WITH ARB LINKS");
		bst.printARB();
		bst.printARBLinked();
		System.out.println("\nTREE WITH ABR LINKS");
		bst.printABR();
		bst.printABRLinked();
		System.out.print("\nREMOVING ELEMENT\nSTART TREE:");
		bst.remove(rem);
		bst.print();
		System.out.println("\nTREE WITH RAB LINKS");
		bst.printRAB();
		bst.printRABLinked();
		System.out.println("\nTREE WITH ARB LINKS");
		bst.printARB();
		bst.printARBLinked();
		System.out.println("\nTREE WITH ABR LINKS");
		bst.printABR();
		bst.printABRLinked();
	}

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			value = data;
			left = right = null;
		}
	}

	public static class Value {
		public int value;

		public Value(int data) {
			value = data;
		}
	}
}