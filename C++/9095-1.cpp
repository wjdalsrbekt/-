// d[n]=d[n-1]+d[n-2]+d[n-3]
// n�� 1,2,3 ���̳��� �ִ� n-3���� ���ϱ�,n �� 3���ϴ� ��꺸�� �̸� �Է�
//bottom up : for��


#include <bits/stdc++.h>
using namespace std;
int d[11];
int main() {
	int n;
	scanf("%d", &n);
	d[1] = 1;
	d[2] = 2;
	d[3] = 4;
	for (int i = 4; i <= 11; i++) {
		d[i] = d[i - 1] + d[i - 2] + d[i - 3];
	}
	for (int j = 0; j < n; j++)
	{
		int tmp;
		scanf("%d", &tmp);
		printf("%d\n", d[tmp]);
	}
}