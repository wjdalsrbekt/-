#include <bits/stdc++.h>


//d[n] = 2*n 채우는 방법
//n번째 타일을 어떻게 놔야되는지 
//n번째 타일을 세로로 놀 때 --> 2(n-1)
//n번째 타일을 가로로 놀 때 --> 2(n-2)
//d[n] = d[n-1] + d[n-2]
using namespace std;
//bottom-up --> for
int d[1001];
int main() {
	int n;
	scanf("%d", &n);
	d[1] = 1;
	d[2] = 2;
	if (n > 2)
	{
		for (int i = 3; i <= n; i++)
			d[i] = (d[i - 1] + d[i - 2])%10007;
	}
	printf("%d", d[n]);
}