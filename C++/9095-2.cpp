//d[n]=d[n-1]+d[n-2]+d[n-3], �߰��Ǵ� ���ڵ��� �������� 1,2,3 ������ �ִ� 3���̳��� �ͱ��� ���ϱ�
//n �� 3���ϴ� �̸� �Է� --> d[0] = 1 �̶�� �ϸ� ���� d[n]���� n�� 3���ϸ� d[0]���� d[n-1]���� ���ϸ� �ȴ�. 
//top-down --> ��͹�

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