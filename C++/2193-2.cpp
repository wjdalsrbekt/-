// d0[i] : i ��° �ڸ� ��ģ�� �϶� ���ڸ��� 0�� ���
// d1[i] : i ��° �ڸ� ��ģ�� �϶� ���ڸ��� 1�� ���
// ���ڸ��� 1�� ��� 0�� �߰��� �� �ִ�.  -->  d1[i] = d0[i-1]
// ���ڸ��� 0�� ��� 0,1�� �߰��� �� �ִ�. --> d0[i] = d0[i-1]+d1[i-1]
// top-down : ����� ����Ǯ�� ū�ſ��� �����ɷ� ������ �����ź��� �ذ� �ַ� ��ͷ� ����Ǯ�� ����

// ���� Ǯ��
// d[n] = n �ڸ� ��ģ��
// n��° �ڸ��� 0 : d[n-1]
// n��° �ڸ��� 1 : 1�� �ýÿ� ������ �� ���ڸ��� 0 �����ڸ���(d[n-1]) 0�� ��ģ���� ������ d[n-2]
#include <bits/stdc++.h>

using namespace std;

long long d0[91];
long long d1[91];
long long go_1(int n);
long long go_0(int n) {
	if (n == 0)return 0;
	else if (d0[n] > 0) return d0[n];
	d0[n] = go_0(n - 1) + go_1(n - 1);
	return d0[n];
}
long long go_1(int n) {
	if (n == 0) return 0;
	else if (d1[n] > 0) return d1[n];
	d1[n] = go_0(n - 1);
	return d1[n];
}
int main() {
	int n;
	scanf("%d", &n);
	d0[1] = 0, d1[1] = 1;
	//long long ans = go_0(n) + go_1(n);
	printf("%lld", go_0(n)+go_1(n));
	//printf("%lld", ans);
}