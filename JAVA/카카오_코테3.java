import java.util.Stack;

public class 카카오_코테3 {
	static int n = 8;
	static int k = 2;
	static String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };

	static Node[] arrList;
	static Stack<Integer> stack;

	static int[] dp;
	static int tmpNUM;

	public static void main(String[] args) {
		int len = cmd.length;
		stack = new Stack<>();
		arrList = new Node[n];
		dp = new int[n];
		for (int i = 0; i < n; i++) {
			arrList[i] = new Node(i, i, true);
			dp[i] = i;
		}
		tmpNUM = n;
		for (int i = 0; i < len; i++) {
			char tmp = cmd[i].charAt(0);
			int tmpGo;
			if (tmp == 'D') {
				tmpGo = cmd[i].charAt(2) - '0';
				Down(tmpGo);

			} else if (tmp == 'U') {
				tmpGo = cmd[i].charAt(2) - '0';
				Up(tmpGo);
			} else if (tmp == 'C') {
				stack.push(dp[k]);
				arrList[dp[k]].per = false;
				// 숫자연산
				Change(k);
			} else if (tmp == 'Z') {
				int recur = stack.peek();
				stack.pop();
				arrList[recur].per = true;
				// 숫자 연산
				Zedo(recur);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (arrList[i].per == true) {
				sb.append("O");
			} else {
				sb.append("X");
			}
		}
		System.out.println(sb.toString());
	}

	static void Down(int tmpGo) {
		if (k + tmpGo >= tmpNUM) {
			return;
		}
		k += tmpGo;
	}

	static void Up(int tmpGo) {
		if (k - tmpGo < 0) {
			return;
		}
		k -= tmpGo;
	}

	static void Change(int num) {
		while (num < tmpNUM) {
			if (dp[num] == -1) {
				tmpNUM = num-1;
				return;
			}
			if (num < tmpNUM - 1)
				dp[num] = dp[num + 1];
			else
				dp[num] = -1;
			num += 1;
		}
	}

	static void Zedo(int num) {
		int idx = 0;
		while (tmpNUM - idx > num) {
			dp[tmpNUM - idx] = dp[tmpNUM - (idx + 1)];
			idx += 1;
		}
		dp[tmpNUM-idx]=num;
	}

	static class Node {
		int originNum;
		int tmpNum;
		boolean per;

		public Node(int originNum, int tmpNum, boolean per) {
			this.originNum = originNum;
			this.tmpNum = tmpNum;
			this.per = per;
		}

	}
}
