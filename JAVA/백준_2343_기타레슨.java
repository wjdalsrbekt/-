import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2343_기타레슨 {
	static int[] arr;
	static int[] arr2;
	static int[] arr3;
	static int n;
	static int m;
	static int ans = 0;

	static int max;
	static int zxc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		arr2 = new int[m];
		arr3 = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			ans += arr[i];
		}
		max = ans / m; // 합의 평균
		int tmp = n / m;
		int idx = 0;
		int cnt = 0;
		arr3[0]=0;
		for (int i = 0; i < n; i++) {
			arr2[idx] += arr[i];
			cnt++;
			if (cnt == tmp) {
				cnt = 0;
				idx += 1;
				if(idx==m)
					break;
				arr3[idx] = i+1;
			}
		}
		int qwe = 0;
		for (int i = n - 1; i >= 0; i--) {
			qwe += arr[i];
			if (max <= qwe)
				break;
		}
		zxc = qwe;
		list();
		System.out.println(zxc);
	}

	static void list() {
		int tmp = 0;
		for (int i = 0; i < m; i++) {
			tmp = tmp > arr2[i] ? tmp : arr2[i];
		}
		while (tmp > zxc) {
			for (int i = m - 1; i > 0; i--) { // 0부터시작인거 기억하기
				if (arr2[i] > zxc) {
					arr2[i] = arr2[i] - arr[arr3[i]];
					arr2[i - 1] = arr2[i - 1] + arr[arr3[i]];
					arr3[i] += 1;// 시작위치 옮기기
				}
			}
			tmp=0;
			for (int i = 0; i < m; i++) {
				tmp = tmp > arr2[i] ? tmp : arr2[i];
			}

		}
		zxc = tmp;
	}
}
