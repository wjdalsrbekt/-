import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14002_가장긴증가하는부분수열4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		StringBuilder sb2=new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

//		String[] line = new String[n];
		int[] d = new int[n];

		node[] line = new node[n];
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		node max = new node();
		for (int i = 0; i < n; i++) {
			line[i]=new node();
			line[i].L = 1;
			sb = new StringBuilder();
			sb2 = new StringBuilder();
			sb.append(d[i]+" ");
			for (int j = 0; j <= i - 1; j++) {
				if (d[i] > d[j] && line[i].L < line[j].L + 1) {
					sb2 = new StringBuilder();
					line[i].L = line[j].L + 1;
					sb2.append(line[j].line);
				}
			}
			line[i].line = sb2.toString()+sb.toString();

			max = max.L > line[i].L ? max : line[i];

		}
		System.out.println(max.L);
		System.out.println(max.line.toString());
	}

	static class node {
		String line;
		int L = 0;

		public node() {

		}
	}
}
