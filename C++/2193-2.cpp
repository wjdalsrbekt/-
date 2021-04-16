// d0[i] : i 번째 자리 이친수 일때 끝자리가 0일 경우
// d1[i] : i 번째 자리 이친수 일때 끝자리가 1일 경우
// 끝자리가 1일 경우 0만 추가될 수 있다.  -->  d1[i] = d0[i-1]
// 끝자리가 0일 경우 0,1이 추가될 수 있다. --> d0[i] = d0[i-1]+d1[i-1]
// top-down : 하향식 문제풀이 큰거에서 작은걸로 나누고 작은거부터 해결 주로 재귀로 문제풀이 진행

// 공식 풀이
// d[n] = n 자리 이친수
// n번째 자리에 0 : d[n-1]
// n번째 자리에 1 : 1이 올시엔 무조건 그 전자리가 0 그전자리가(d[n-1]) 0인 이친수의 갯수는 d[n-2]
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