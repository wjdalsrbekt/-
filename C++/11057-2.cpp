//top down 하향식 재귀
// d[n][j] : n 자리 j로 끝나는 수
// d[n][j] 은 d[n-1][j] + d[n-1][j-1] + ... + d[n-1][j-j]

#include <bits/stdc++.h>
using namespace std;
long long d[1001][10];

long long go(int n, int l) {
	if (n == 1) return 1;
	if (d[n][l]) return d[n][l];
	for (int i = l; i >= 0; i--)
		d[n][l] += go(n - 1, i);
	d[n][l] %= 10007;
	return d[n][l];
}
int main() {
	int n;
	long long ans = 0;
	scanf("%d", &n);
	for (int i = 0; i <= 9; i++)
		ans+=go(n, i);
	ans %= 10007;
	printf("%d", ans);
}