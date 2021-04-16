import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 백준_16235_나무재테크 {
	private static class Node {
		int x, y, value;
		Node(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	
	static int size, num, year;
	static int[][] addNutri;
	static int[][] origin;
	static Queue<Node> save = new LinkedList<>();
	static Queue<Node> death = new LinkedList<>();
	static PriorityQueue<Node> pq 
		= new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.value - o2.value;
		}
	}); 
	
	static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
	static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		size = input.nextInt();
		num = input.nextInt();
		year = input.nextInt();
		addNutri = new int[size+1][size+1];
		origin = new int[size+1][size+1];
		
		for(int i = 1; i <= size; i++) {
			for(int j = 1; j <= size; j++) {
				origin[i][j] = 5;
				addNutri[i][j] = input.nextInt();
			}
		}
		
		for(int i = 0; i < num; i++) {
			int temp1 = input.nextInt();
			int temp2 = input.nextInt();
			pq.add(new Node(temp1, temp2, input.nextInt()));
		}
		
//		for(int i = 0; i < num; i++) { // 우선순위큐 동작확인
//			Node temp = pq.poll();
//			System.out.println("(x,y) = value   ->   " + temp.x +","+temp.y+" = "+temp.value);
//		}
		
		for(int i = 0; i < year; i++) {
			spring();
			summer();
			autumn();
			winter();
		}
		System.out.println(pq.size());
	}
	
	private static void spring() {
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			if(origin[temp.x][temp.y] >= temp.value) { // 봄
				origin[temp.x][temp.y] -= temp.value;
				temp.value += 1;
				save.add(temp);
			} else { // 여름
				death.add(temp);
			}
		}
	}
	
	private static void summer() {
		while(!death.isEmpty()) {
			Node temp = death.poll();
			origin[temp.x][temp.y] += temp.value/2; 
		}
	}
	
	private static void autumn() {
		while(!save.isEmpty()) {
			Node temp = save.poll();
			if(temp.value % 5 == 0) {
				spread(temp.x, temp.y);
			}
			pq.add(temp);
		}
	}
	
	private static void spread(int x, int y) {
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 1 && ny >= 1 && nx <= size && ny <= size) {
				pq.add(new Node(nx, ny, 1));		
			}
		}
	}
	
	private static void winter() {
		for(int i = 1; i <= size; i++) {
			for(int j = 1; j <= size; j++) {
				origin[i][j] += addNutri[i][j];
			}
		}
	}
}
