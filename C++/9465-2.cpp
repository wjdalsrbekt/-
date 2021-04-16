//top down 하향식 재귀
// *********************************************시간초과
// d[n][s] : n열 상태 s 일때
// s상태는 총 3가지 xx ,ox, xo

// a[i][j] i번째 행 j번째 열 스티커 점수
// d[n][0] = max(d[n-1][0],d[n-1][1],d[n-1][2])
// d[n][1] = max(d[n-1][0],d[n-1][2])+a[n][1]
// d[n][2] = max(d[n-1][0],d[n-1][1])+a[n][2]

#include <bits/stdc++.h>
#include <cstring>
using namespace std;

long long d[100001][3];
long long a[100001][3];
long long go(int n,int s) {
	if (n == 0) return 0;
	if (d[n][s] > 0) return d[n][s];
	if (s == 0)
		d[n][s] = max(go(n - 1, 0), max(go(n - 1, 1), go(n - 1, 2)));
	else if (s == 1)
		d[n][s] = max(go(n - 1, 0), go(n - 1, 2)) + a[n][s];
	else if (s == 2)
		d[n][s] = max(go(n - 1, 0), go(n - 1, 1)) + a[n][s];
	return d[n][s];
}
int main() {
	int n;
	int m;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &m);
		memset(d, 0, sizeof(d));
		for (int k = 1; k <= m; k++)
			scanf("%d", &a[k][1]);
		for (int k = 1; k <= m; k++)
			scanf("%d", &a[k][2]);
		go(m, 3);
		/*for (int k = 1; k <= m; k++) {
			for (int q = 0; q < 3; q++)
				printf("%lld ", d[k][q]);
			printf("\n");   더해지는 과정 
		}*/
		printf("%lld\n", max(d[m][0], max(d[m][1], d[m][2])));
	}
}