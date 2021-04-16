// d[1] = 1
// d[2] = 3
// d[n] = d[n-1] + d[n-2] +d[n-2]

//bottom - up  : for문 으로 풀기
#include <bits/stdc++.h>

using namespace std;
int d[1001];
int main() {
	int n;
	scanf("%d", &n);
	d[1] = 1;
	d[2] = 3;
	if(n>=3)
		for (int i = 3; i <= n; i++) {
			d[i] = (d[i - 1] + d[i - 2] + d[i - 2])%10007;
		}
	printf("%d", d[n]);
	
}