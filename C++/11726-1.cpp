#include <bits/stdc++.h>


//d[n] = 2*n ä��� ���
//n��° Ÿ���� ��� ���ߵǴ��� 
//n��° Ÿ���� ���η� �� �� --> 2(n-1)
//n��° Ÿ���� ���η� �� �� --> 2(n-2)
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