/*
* 포도주의 순서는 따로 없으니 우리가 순서를 지정해도됨.
* 2차원 배열로 푸는 방법
* d[i][j]=a[1]~a[i] 포도주 i번째잔 : 연속 j번
* 0번 연속 : d[n][0] = max(d[n-1][0],d[n-1][1],d[n-1][2])
* 1번 연속 : d[n][1] = d[n-1][0] + a[n]
* 2번 연속 : d[n][2] = d[n-1][1] + a[n]
* 
* 1차원 배열로 푸는 방법
* d[n]= a[1]~a[n] 포도주
* 0번 연속 : d[n-1]
* 1번 연속 : d[n-2] + a[n]
* 2번 연속 : d[n-3] + a[n] + a[n-1] 
*/
#include <bits/stdc++.h>

using namespace std;

long long d[10001];
long long a[10001];
int main() {
	int n;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &a[i]);
	}
	d[1] = a[1];
	d[2] = a[1] + a[2];
	for (int i = 3; i <= n; i++) {
		d[i] = d[i - 1]; // 0번연속
		if (d[i] < d[i - 2] + a[i])  //1번연속
			d[i] = d[i - 2] + a[i];
		if (d[i] < d[i - 3] + a[i] + a[i - 1]) //2번연속
			d[i] = d[i - 3] + a[i] + a[i - 1];
	}
	printf("%d", d[n]);
}