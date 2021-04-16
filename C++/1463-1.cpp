// key point!
// N을 무조건 소인수 분해 하면 되지않냐 ?
// 정답은 아니다.
// 그 이유는 10인경우 처음에 2를 나누면 10->5->4->2->1 로 계산이 4번 이지만,
// 10->9->3->1 계산이 3번만으로 끝나기 때문이다.

// 따라서 DP로 풀어야하는데 , 이럴땐 D[N]을 먼저 정의 해줘야한다. 

// D[N]=
// 1) D[N] = D[N/3] + 1
// 2) D[N] = D[N/2] + 1
// 3) D[N] = D[N-1] + 1


#include <bits/stdc++.h>
//bottom-up //for문
using namespace std;
int d[1000001];
int main() {
	int n;
	scanf("%d", &n);
	d[1] = 0;
	for (int i = 2; i <= n; i++) {
		d[i] = d[i - 1] + 1;
		if (i% 2 == 0 && d[i] > d[i / 2] + 1)
			d[i] = d[i / 2] + 1;
		if (i % 3 == 0 && d[i] > d[i / 3] + 1)
			d[i] = d[i / 3] + 1;
	}
	printf("%d", d[n]);
}