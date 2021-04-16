#include <iostream>

using namespace std;
long long arr[100001][4];
int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);
	int n,m;
	long long ans;
	cin >> n;
	arr[1][1] = 1;
	arr[2][2] = 1;
	for (int i = 1; i <= 3; i++)
		arr[3][i] += 1;
	for (int i = 1; i <= n; i++)
	{
		cin >> m;
		ans = 0;
		
		for (int j = 4; j <= m; j++) {
			arr[j][1] = (arr[j - 1][2] + arr[j - 1][3])%1000000009;
			arr[j][2] = (arr[j - 2][1] + arr[j - 2][3])%1000000009;
			arr[j][3] = (arr[j - 3][1] + arr[j - 3][2])%1000000009;
		}
		for (int a = 1; a <= 3; a++)
		{
			ans += arr[m][a];
		}
		
		ans %= 1000000009;
		cout << ans<<endl;
	}

}