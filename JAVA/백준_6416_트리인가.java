import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 백준_6416_트리인가 {
	static int[][] arr;
	static int[] arr_u;
	static int[] arr_v;
	static int root;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[15][15];
		arr_u = new int[15];
		arr_v = new int[15];
		int idx = 0;
		while (true) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			if (u == -1 && v == -1)
				break;
			arr[u][v] += 1;
			arr_u[u] += 1;
			arr_v[v] += 1;
			if (u == 0 && v == 0) {
				idx += 1;
				int tmp = 0;
				for (int i = 0; i < 15; i++) {
					if (arr_v[i] >= 2) {
						tmp += 1;
					}
				}
				find_root();
				if (root == -1) {
					System.out.println("Case " + idx + " is not a tree.");
				} else if (root >= 0 && tmp == 0) {
					System.out.println("Case " + idx + " is a tree.");
				} else if (tmp > 0) {
					System.out.println("Case " + idx + " is not a tree.");
				}
				arr = new int[15][15];
				arr_u = new int[15];
				arr_v = new int[15];
				root = 0;
			}
		}
	}

	static void find_root() {
		int flag = 0;
		int tmp = 0;
		for (int i = 1; i < 15; i++) {
			if (arr_u[i] >= 1 && arr_v[i] == 0) {
				for (int j = 1; j < 15; j++) {
					if (arr[j][i] != 0) {
						flag = 1;
						break;
					}
				}
				if (flag == 0 && tmp == 0) {
					root = i;
					tmp = 1;
				} else if (root != 0 && flag == 0 && tmp != 0) {
					root = -1;
				}
			}
		}
		if (root == 0) {
			for (int i = 1; i < 15; i++) {
				if (arr_u[i] != 0 || arr_v[i] != 0) // 0외에 다른숫자가들어왔더넛
				{
					root = -1;
				}
			}
		}
	}

}