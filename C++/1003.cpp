#include <bits/stdc++.h>

using namespace std;
void fibonacci();
int arr[41][2];
int A;

int main() {
	int T,N;
	arr[0][0] = 1;
	arr[0][1] = 0;
	arr[1][0] = 0;
	arr[1][1] = 1;

	scanf("%d", &T);
	fibonacci();
	for (int i = 0; i < T; i++) {
		scanf("%d", &N);
		for (int j = 0; j < 2; j++)
			printf("%d ", arr[N][j]);
		printf("\n");
	}
}

void fibonacci() {
	for (int i = 2; i <= 40; i++)
	{
		arr[i][0] = arr[i - 1][0] + arr[i - 2][0];
		arr[i][1] = arr[i - 1][1] + arr[i - 2][1];
	}
}