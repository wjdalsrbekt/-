// d[n][j] : n�ڸ� �϶� ���ڸ��� j �μ�
// d[n][j] �� ���������� �� �� �ִ� �� 
// d[n-1][j] ,d[n-1][j-1] ... d[n-1][0]


//bottom up ����� for��

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