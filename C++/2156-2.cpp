/* 
bottom up for�� 
2���� �迭 
a[i]
d[i][j] : d i�϶� j��° ��������
0�� ���� = d[i][0] : max(d[i-1][0],d[i-1][1],d[i-1][2])
1�� ���� = d[i][1] : d[i-1][0] + a[i]
2�� ���� = d[i][2] : d[i-1][1] + a[i]

1���� �迭
0�� ���� = d[i] : d[i-1]
1�� ���� = d[i] : d[i-2] + a[i]
2�� ���� = d[i] : d[i-3] + a[i-1] + a[i]
*/

#include <bits/stdc++.h>

using namespace std;
long long d[10001][3];
long long a[10001];
int main() {
	int n;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++)
	{
		scanf("%d", &a[i]);
		
		d[1][1] = a[1];
		d[1][2] = a[1];

		for (int j = 2; j <= n; j++) {
			d[j][0] = max(d[j - 1][0], max(d[j - 1][1], d[j - 1][2]));
			d[j][1] = d[j - 1][0] + a[j];
			d[j][2] = d[j - 1][1] + a[j];
		}
		
	}
	printf("%lld", max(d[n][0], max(d[n][1], d[n][2])));
}
