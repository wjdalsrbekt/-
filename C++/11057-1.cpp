// d[n][j] : n자리 일때 끝자리가 j 인수
// d[n][j] 가 오르막수가 될 수 있는 것 
// d[n-1][j] ,d[n-1][j-1] ... d[n-1][0]


//bottom up 상향식 for문

#include <bits/stdc++.h>
using namespace std;
long long d[1001][10];
long long ans;
int main() {
	int n;
	scanf("%d", &n);
	for (int i = 0; i <= 9; i++)
		d[1][i] = 1;
	for (int i=2;i<=n;i++)
		for (int j = 0; j <= 9; j++) {
			for (int l = j; l >= 0; l--)
				d[i][j] += d[i-1][l];
			d[i][j] %= 10007;
		}
	for (int i = 0; i <= 9; i++)
		ans += d[n][i];
	ans %= 10007;
	printf("%d", ans);
}