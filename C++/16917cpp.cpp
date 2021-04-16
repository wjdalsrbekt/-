#include <iostream>
using namespace std;
int main() {
	long long A, B, C;
	long long X, Y;

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> A >> B >> C >> X >> Y;
	long long ans = 0;
	long long min;
	long long max;
	min = X < Y ? X : Y;
	max = X > Y ? X : Y;
	long long tmp;
	ans = A * X + B * Y;
	for (int i = 0; i <= min; i++)
	{
		tmp = A * (X - i) + B * (Y - i) + 2 * C * i;
		ans = ans < tmp ? ans : tmp;
		//cout << ans << endl;
	}
	tmp = 2 * C * max;
	ans = ans < tmp ? ans : tmp;

	cout << ans;
}