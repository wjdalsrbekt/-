// bottom - up : 상향식 방식 작은 문제 부터 처리  --> for 문
// d[n][l] =  n 자리 계단 수 마지막 수 : L 
// [L-1/N-1 <-- L/N]  or [L+1/N-1 <-- L/N]
// 점화식
// d[n][l] = d[n-1][l-1] + d[n-1][l+1] (1<=l<=8)
// d[n][0] = d[n-1][1]
// d[n][9] = d[n-1][8]


#include <bits/stdc++.h>

using namespace std;
long long mod = 1000000000;
long long d[101][10];
int main() {
	int n;
	long long ans = 0;
	scanf("%d", &n);
	for (int i = 1; i <= 9; i++)
		d[1][i] = 1;
	for (int i = 2; i <= n; i++) {
		for (int j = 0; j <= 9; j++) {
			//d[i][j] = 0;
			if (j - 1 >= 0)
				d[i][j] += d[i - 1][j - 1];
			if (j + 1 <= 9)
				d[i][j] += d[i - 1][j + 1];
			d[i][j] %= mod;
		}
	}
	for (int i = 0; i <= 9; i++)
	{
		ans += d[n][i];
	}
	ans %= mod; // 10억 으로 나눈 나머지를 저장했으니, 
	/*dp[n][j]에는 0~9억9999만 9999까지의 수중 하나가 들어있다.*/
	/*이걸 10번 더하면 10억이 넘을 수 있는 것.*/
	printf("%lld", ans);
}