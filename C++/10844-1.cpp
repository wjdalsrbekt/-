// bottom - up : ����� ��� ���� ���� ���� ó��  --> for ��
// d[n][l] =  n �ڸ� ��� �� ������ �� : L 
// [L-1/N-1 <-- L/N]  or [L+1/N-1 <-- L/N]
// ��ȭ��
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
	ans %= mod; // 10�� ���� ���� �������� ����������, 
	/*dp[n][j]���� 0~9��9999�� 9999������ ���� �ϳ��� ����ִ�.*/
	/*�̰� 10�� ���ϸ� 10���� ���� �� �ִ� ��.*/
	printf("%lld", ans);
}