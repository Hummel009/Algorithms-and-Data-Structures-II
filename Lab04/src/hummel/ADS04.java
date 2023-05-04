package hummel;

import java.util.Arrays;
import java.util.Scanner;

public class ADS04 {
	public static Scanner scan = new Scanner(System.in);
	public static int[] step = new int[100];
	public static int[][] arrv = new int[10][10];

	public static void main(String[] args) {
		int[] arrp = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		for (int sus = 0; sus < 100; sus++) {
			step[sus] = 0;
		}

		System.out.print("Write Number of Nodes: ");
		int i = scan.nextInt();

		for (int j = 0; j < i; j++) {
			for (int k = 0; k < i; k++) {
				if (j != k) {
					System.out.printf("Write the Distance: %d -> %d: ", j + 1, k + 1);
					arrv[j][k] = scan.nextInt();
				} else {
					arrv[j][k] = 0;
				}
			}
		}

		System.out.print("\n  |");
		for (int k = 0; k < i; k++) {
			System.out.printf("__%d_|", k + 1);
		}

		System.out.print("\n");

		for (int j = 0; j < i; j++) {
			System.out.printf("|%d|", j + 1);
			for (int k = 0; k < i; k++) {
				System.out.printf(" %2d |", arrv[j][k]);
			}
			System.out.print("\n");
		}

		System.out.print("\nFind a way from: ");
		int tmp1 = scan.nextInt();

		System.out.print("Find a way to: ");
		int tmp2 = scan.nextInt();

		arrp[tmp1 - 1] = 0;
		search(tmp1 - 1, 0, arrp, tmp1 - 1, tmp2 - 1, i, 0);

		int y = 0;
		while (step[y] != 0) {
			y++;
		}

		System.out.print("\n");

		for (int g = 0; g < y - 1; g++) {
			for (int j = 0; j < y - g - 1; j++) {
				if (step[j] > step[j + 1]) {
					int tmps = step[j];
					step[j] = step[j + 1];
					step[j + 1] = tmps;
				}
			}
		}

		int[] arrm = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		System.out.print("Min: ");
		arrm[0] = tmp1;
		maxMin(tmp1 - 1, 0, arrp, tmp1 - 1, tmp2 - 1, i, 0, step[0], arrm);

		System.out.print("Max: ");
		maxMin(tmp1 - 1, 0, arrp, tmp1 - 1, tmp2 - 1, i, 0, step[y - 1], arrm);

		System.out.print("\nAll: \n");
		for (int g = 0; g < y; g++) {
			if (g == 0 || step[g] != step[g - 1]) {
				maxMin(tmp1 - 1, 0, arrp, tmp1 - 1, tmp2 - 1, i, 0, step[g], arrm);
			}
		}

		int[][] ex = new int[11][11];

		for (int c1 = 0; c1 < 11; c1++) {
			Arrays.fill(ex[c1], 0);
		}

		for (tmp1 = 1; tmp1 <= i; tmp1++) {
			for (tmp2 = 1; tmp2 <= i; tmp2++) {
				for (int g = 0; g <= i; g++) {
					arrp[g] = 1;
				}

				int g1 = 0;
				while (step[g1] != 0) {
					step[g1] = 0;
					g1++;
				}

				arrp[tmp1 - 1] = 0;
				search(tmp1 - 1, 0, arrp, tmp1 - 1, tmp2 - 1, i, 0);

				int w = 0;
				while (step[w] != 0) {
					w++;
				}

				for (int g = 0; g < w - 1; g++) {
					for (int j = 0; j < w - g - 1; j++) {
						if (step[j] > step[j + 1]) {
							int tmps = step[j];
							step[j] = step[j + 1];
							step[j + 1] = tmps;
						}
					}
				}
				ex[tmp1 - 1][tmp2 - 1] = step[0];

			}
		}

		for (int maxj = 0; maxj < i; maxj++) {
			int temp = 2;
			int tempmax = ex[0][maxj];
			if (tempmax == 0) {
				temp--;
			}

			for (int maxi = 1; maxi < i; maxi++) {
				if (ex[maxi][maxj] > tempmax) {
					tempmax = ex[maxi][maxj];
				}

				if (ex[maxi][maxj] == 0) {
					temp--;
				}
			}

			if (temp > 0) {
				ex[i][maxj] = tempmax;
			} else {
				ex[i][maxj] = 0;
			}
		}

		System.out.print("\n  |");
		for (int k = 0; k < i; k++) {
			System.out.printf("__%d_|", k + 1);
		}

		System.out.print("\n");

		for (int j = 0; j < i; j++) {
			System.out.printf("|%d|", j + 1);
			for (int k = 0; k < i; k++) {
				System.out.printf(" %2d |", ex[j][k]);
			}
			System.out.print("\n");
		}

		int tempmin = ex[i][0];
		for (int maxj = 1; maxj < i; maxj++) {
			if (ex[i][maxj] < tempmin && ex[i][maxj] != 0) {
				tempmin = ex[i][maxj];
			}
		}

		System.out.print("\nCenter(s): ");
		for (int maxj = 0; maxj < i; maxj++) {
			if (ex[i][maxj] == tempmin) {
				System.out.printf("%d ", maxj + 1);
			}
		}
	}

	private static void maxMin(int j, int k, int[] arrp, int tmp1, int tmp2, int i, int tmp, int mm, int[] arrm) {
		while (k < i && j != tmp2) {
			if (arrv[j][k] != 0 && arrp[k] != 0) {
				int[] arrpt = arrp.clone();
				int[] arrmt = arrm.clone();
				int g = 0;
				while (arrmt[g] != 0) {
					g++;
				}
				arrmt[g] = k + 1;
				arrpt[k] = 0;
				maxMin(k, 0, arrpt, tmp1, tmp2, i, tmp + arrv[j][k], mm, arrmt);
			}
			k++;
		}

		if (j == tmp2 && tmp == mm) {
			System.out.printf("%d ", arrm[0]);
			int g = 1;
			while (arrm[g] != 0) {
				System.out.printf("-> %d ", arrm[g]);
				g++;
			}
			System.out.printf("(%d)\n", tmp);
		}
	}

	private static void search(int j, int k, int[] arrp, int tmp1, int tmp2, int i, int tmp) {
		while (k < i && j != tmp2) {
			if (arrv[j][k] != 0 && arrp[k] != 0) {
				int[] arrpt = arrp.clone();
				arrpt[k] = 0;
				search(k, 0, arrpt, tmp1, tmp2, i, tmp + arrv[j][k]);
			}
			k++;
		}

		if (j == tmp2) {
			int t = 0;
			while (step[t] != 0) {
				t++;
			}
			step[t] = tmp;
		}
	}
}