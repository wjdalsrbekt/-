import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1991_트리순회 {
	static int[][] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		tree = new int[26][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char tmp_c = st.nextToken().charAt(0);
			char tmp_l = st.nextToken().charAt(0);
			char tmp_r = st.nextToken().charAt(0);
			int center = (int) (tmp_c - 'A');
			if (tmp_l == '.') {
				tree[center][0] = -1;
			} else {
				tree[center][0] = (int) (tmp_l - 'A');
			}
			if (tmp_r == '.') {
				tree[center][1] = -1;
			} else {
				tree[center][1] = (int) (tmp_r - 'A');
			}
		}
		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0);
	}

	static void preorder(int num) {
		if (num == -1)
			return;
		System.out.print((char) (num + 'A'));
		preorder(tree[num][0]);
		preorder(tree[num][1]);
	}

	static void inorder(int num) {
		if (num == -1)
			return;
		inorder(tree[num][0]);
		System.out.print((char) (num + 'A'));
		inorder(tree[num][1]);
	}

	static void postorder(int num) {
		if (num == -1)
			return;
		postorder(tree[num][0]);
		postorder(tree[num][1]);
		System.out.print((char) (num + 'A'));
	}
}
