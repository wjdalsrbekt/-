//top down -재귀
// d[n][i] : n 자리 중에 끝자리 i인 계단 수 갯수
// d[n][i] 는 d[n-1][i-1] 와 d[n-1][i+1]가 될 수 있다.

// d[n][i] = d[n-1][i-1] + d[n-1][i+1] (1<=l<=8)
// d[n][0] = d[n-1][i+1]
// d[n][9] = d[n-1][i-1]
#include <bits/stdc++.h>

using namespace std;

long long d[101][10] = { -1,-1, };
long long mod = 1000000000;
long long ans;
long long go(int n, int l);
int main() {
	int n;
	scanf("%d", &n);

	for (int i = 0; i <= 9; i++)
		ans=(ans+go(n, i))%mod;
	printf("%lld", ans);
}

long long go(int n,int l) {
	if (n == 1) {
		if (l == 0) return 0;
		else return 1;
	}
	if (d[n][l] > 0) return d[n][l];
	else
	{
		if (l - 1 >= 0)
			d[n][l] += go(n-1,l-1);
		if (l + 1 <= 9)
			d[n][l] += go(n-1,l+1);
		d[n][l] %= mod;
	}
	return d[n][l];
}