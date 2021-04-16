//bottom up for문 하향식 

// 스티커 떼는 순서는 언급을 문제 에서 안함 --> 스티커 떼는 순서는 지정 가능
//  x   o   x                              o
//  x   x   o                              o
//  0번 1번 2번  각각의 스티커를 모두 뜯는 3번 일경우, 문제조건에 위배

// d[n][s]= 2*n 스티커 n열 상태가 s (s는 각 0,1,2번 경우중 하나)
// A[i][j] : i번열 j번행에 있는 스티커의 점수
// d[n][0] : n번째일때 0번 일 경우, [n-1][0] 번일경우도 올 수 있다. 
// d[n][0] : n번째일때 0번 일 경우, [n-1][1] 번일경우도 올 수 있다.
// d[n][0] : n번째일때 0번 일 경우, [n-1][2] 번일경우도 올 수 있다.
// <--점화식-->
// d[n][0] = max(d[n-1][0],d[n-1][1],d[n-1][2]) 이와같이 진행하면
// d[n][1] = max(d[n-1][0],d[n-1][2]) + A[n][1]
// d[n][2] = max(d[n-1][0],d[n-1][1]) + A[n][2]

// 정답은 max (d[n][0],d[n][1],d[n][2])
#include <bits/stdc++.h>

using namespace std;
long long d[100001][3];
long long a[100001][3];
int main() {
	int n,m;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &m);
		for (int k = 1; k <= m; k++)
			scanf("%d", &a[k][1]);
		for (int k = 1; k <= m; k++)
			scanf("%d", &a[k][2]);
		for (int k = 1; k <= m; k++) {
			d[k][0] = max(d[k - 1][0], max(d[k - 1][1], d[k - 1][2]));
			d[k][1] = max(d[k - 1][0], d[k - 1][2]) + a[k][1];
			d[k][2] = max(d[k - 1][0], d[k - 1][1]) + a[k][2];
		}
		printf("%lld\n", max(d[m][0], max(d[m][1], d[m][2])));
	}
	
}