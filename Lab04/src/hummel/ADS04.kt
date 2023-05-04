package hummel

import java.util.*

var step = IntArray(100)
lateinit var arrv: Array<IntArray>

fun main() {
	val scan = Scanner(System.`in`)
	print("Write Number of Nodes: ")
	val i = scan.nextLine().toInt()

	arrv = Array(i) { IntArray(i) }
	for (j in 0 until i) {
		for (k in 0 until i) {
			if (j != k) {
				System.out.printf("Write the Distance: %d -> %d: ", j + 1, k + 1)
				arrv[j][k] = scan.nextLine().toInt()
			} else {
				arrv[j][k] = 0
			}
		}
	}

	print("\n  |")
	for (k in arrv.indices) {
		System.out.printf("__%d_|", k + 1)
	}

	print("\n")
	for (j in arrv.indices) {
		System.out.printf("|%d|", j + 1)
		for (k in arrv[j].indices) {
			System.out.printf(" %2d |", arrv[j][k])
		}
		print("\n")
	}

	print("\nFind a way from: ")
	var tmp1 = scan.nextLine().toInt()

	print("Find a way to: ")
	var tmp2 = scan.nextLine().toInt()

	val arrp = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
	arrp[tmp1 - 1] = 0
	search(tmp1 - 1, 0, arrp, tmp1 - 1, tmp2 - 1, i, 0)
	var y = 0
	while (step[y] != 0) {
		y++
	}
	print("\n")
	for (g in 0 until y - 1) {
		for (j in 0 until y - g - 1) {
			if (step[j] > step[j + 1]) {
				val tmps = step[j]
				step[j] = step[j + 1]
				step[j + 1] = tmps
			}
		}
	}
	val arrm = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
	print("Min: ")
	arrm[0] = tmp1
	maxMin(tmp1 - 1, 0, arrp, tmp1 - 1, tmp2 - 1, i, 0, step[0], arrm)
	print("Max: ")
	maxMin(tmp1 - 1, 0, arrp, tmp1 - 1, tmp2 - 1, i, 0, step[y - 1], arrm)
	print("\nAll: \n")
	for (g in 0 until y) {
		if (g == 0 || step[g] != step[g - 1]) {
			maxMin(tmp1 - 1, 0, arrp, tmp1 - 1, tmp2 - 1, i, 0, step[g], arrm)
		}
	}
	val ex = Array(11) { IntArray(11) }
	for (c1 in 0..10) {
		Arrays.fill(ex[c1], 0)
	}
	tmp1 = 1
	while (tmp1 <= i) {
		tmp2 = 1
		while (tmp2 <= i) {
			for (g in 0..i) {
				arrp[g] = 1
			}
			var g1 = 0
			while (step[g1] != 0) {
				step[g1] = 0
				g1++
			}
			arrp[tmp1 - 1] = 0
			search(tmp1 - 1, 0, arrp, tmp1 - 1, tmp2 - 1, i, 0)
			var w = 0
			while (step[w] != 0) {
				w++
			}
			for (g in 0 until w - 1) {
				for (j in 0 until w - g - 1) {
					if (step[j] > step[j + 1]) {
						val tmps = step[j]
						step[j] = step[j + 1]
						step[j + 1] = tmps
					}
				}
			}
			ex[tmp1 - 1][tmp2 - 1] = step[0]
			tmp2++
		}
		tmp1++
	}
	for (maxj in 0 until i) {
		var temp = 2
		var tempmax = ex[0][maxj]
		if (tempmax == 0) {
			temp--
		}
		for (maxi in 1 until i) {
			if (ex[maxi][maxj] > tempmax) {
				tempmax = ex[maxi][maxj]
			}
			if (ex[maxi][maxj] == 0) {
				temp--
			}
		}
		if (temp > 0) {
			ex[i][maxj] = tempmax
		} else {
			ex[i][maxj] = 0
		}
	}
	print("\n  |")
	for (k in 0 until i) {
		System.out.printf("__%d_|", k + 1)
	}
	print("\n")
	for (j in 0 until i) {
		System.out.printf("|%d|", j + 1)
		for (k in 0 until i) {
			System.out.printf(" %2d |", ex[j][k])
		}
		print("\n")
	}
	var tempmin = ex[i][0]
	for (maxj in 1 until i) {
		if (ex[i][maxj] < tempmin && ex[i][maxj] != 0) {
			tempmin = ex[i][maxj]
		}
	}
	print("\nCenter(s): ")
	for (maxj in 0 until i) {
		if (ex[i][maxj] == tempmin) {
			System.out.printf("%d ", maxj + 1)
		}
	}
}

private fun maxMin(
	j: Int,
	k: Int,
	arrp: IntArray,
	tmp1: Int,
	tmp2: Int,
	i: Int,
	tmp: Int,
	mm: Int,
	arrm: IntArray
) {
	var k = k
	while (k < i && j != tmp2) {
		if (arrv[j][k] != 0 && arrp[k] != 0) {
			val arrpt = arrp.clone()
			val arrmt = arrm.clone()
			var g = 0
			while (arrmt[g] != 0) {
				g++
			}
			arrmt[g] = k + 1
			arrpt[k] = 0
			maxMin(k, 0, arrpt, tmp1, tmp2, i, tmp + arrv[j][k], mm, arrmt)
		}
		k++
	}
	if (j == tmp2 && tmp == mm) {
		System.out.printf("%d ", arrm[0])
		var g = 1
		while (arrm[g] != 0) {
			System.out.printf("-> %d ", arrm[g])
			g++
		}
		System.out.printf("(%d)\n", tmp)
	}
}

private fun search(j: Int, k: Int, arrp: IntArray, tmp1: Int, tmp2: Int, i: Int, tmp: Int) {
	var k = k
	while (k < i && j != tmp2) {
		if (arrv[j][k] != 0 && arrp[k] != 0) {
			val arrpt = arrp.clone()
			arrpt[k] = 0
			search(k, 0, arrpt, tmp1, tmp2, i, tmp + arrv[j][k])
		}
		k++
	}
	if (j == tmp2) {
		var t = 0
		while (step[t] != 0) {
			t++
		}
		step[t] = tmp
	}
}