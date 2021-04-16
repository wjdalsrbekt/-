//d[n] : n 번째 타일을 놓는 방법
//d[n] = d[n-1] + d[n-2]
//top -down // 재귀 방식
#include <bits/stdc++.h>

using namespace std;
int d[1001];
int go(int n);
int main() {
	int n;
	d[1] = 1;
	d[2] = 2;
	scanf("%d", &n);
	go(n);
	printf("%d", d[n]);
}
int go(int n) {
	if (n == 0) return 0;
	else if (n <= 2) return d[n];
	else if (d[n] > 0) return d[n];
	d[n] = (go(n - 1) + go(n - 2))%10007;
	return d[n];
}