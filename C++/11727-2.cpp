// d[n]=d[n-1]+d[n-2]+d[n-2]

// 2x2 ���簢�� ������ �ѹ� �ٽ� ���ϱ�

// top - down (���)
#include <bits/stdc++.h>
int d[1001];

int go(int n);
int main() {
	int n;
	scanf("%d", &n);
	d[1] = 1;
	d[2] = 3;
	go(n);
	printf("%d", d[n]);
}

int go(int n) {
	if (n == 0) return 0;
	else if (d[n] > 0)return d[n];
	d[n] = (go(n - 1) + go(n - 2) + go(n - 2)) % 10007;
	return d[n];
}