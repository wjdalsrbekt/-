import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_16954_움직이는미로탈출 {
	static char[][] map = new char[8][8];
	static int[] dx = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	static int[] dy = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 8; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}
	}

	static class Node {
		int y;
		int x;
		int time;

		public Node(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}

	}
}
