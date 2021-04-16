
//top down 재귀 하향식.

#include <bits/stdc++.h>
//#include <iostream>
using namespace std;

int d[1001];
int arr[1001]; //각 분야 별최대값
//int max = 1;
int go(int n);
int main() {
	int n;
	
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &d[i]);
		//arr[i] = d[i];
	}
	go(n);
	printf("%d", arr[n]);
}
int go(int n) {
	if (n == 0) return 0;
	if (arr[n] > 0)return arr[n]; //안하면 시간초과
	{
		for (int i = 1; i <= n; i++)
		{//arr[n] = go(n - i) + d[i];
			arr[n] = max(arr[n], go(n-i)+d[i]);
			/*int tmp = 0;
			tmp = go(n - i) + d[i];
			if (arr[n] < tmp)
				arr[n] = tmp;*/
		}
	}
	return arr[n];
}