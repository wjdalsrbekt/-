#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int coin[101];
int ans[10001];
int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);
	int n, k;
	cin >> n>> k;
	for (int i = 1; i <= n; i++)
		cin >> coin[i];
	ans[0] = 1;
	for (int i = 1; i <= n; i++) {
		for (int j = coin[i]; j <= k; j++) {
			ans[j] = ans[j] + ans[j - coin[i]];
			//printf("%d������ �Ἥ ����� �ִ�  %d���� %d �����Դϴ�.\n", coin[i], j, ans[j]);
		}
	}

	cout << ans[k] << endl;
	
}