//d[n]=d[n-1]+d[n-2]+d[n-3], 추가되는 숫자들이 기존에서 1,2,3 까지니 최대 3차이나는 것까지 더하기
//n 이 3이하는 미리 입력 --> d[0] = 1 이라고 하면 만약 d[n]에서 n이 3이하면 d[0]부터 d[n-1]까지 더하면 된다. 
//top-down --> 재귀문

#include <bits/stdc++.h>

using namespace std;
int d[11];
int go(int n);
int main() {
	int n;
	d[1] = 1;
	d[2] = 2;
	d[3] = 4;
	scanf("%d", &n);
	go(11);
	for (int i = 0; i < n; i++) {
		int tmp;
		scanf("%d", &tmp);
		printf("%d\n", d[tmp]);
	}
}
int go(int n) {
	if (n <= 3) return d[n];
	if (d[n] > 0) return d[n];
	d[n] = go(n - 1) + go(n - 2) + go(n - 3);
	return d[n];
}