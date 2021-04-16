//#include <iostream>
//
//using namespace std;
//unsigned long long fi[10001];
//int main() {
//	int n;
//	unsigned long long p[10001];
//
//	unsigned long long q[10001];
//	unsigned long long max=1;
//	unsigned long long ans = 0;
//	cin.tie(0);
//	cout.tie(0);
//	ios_base::sync_with_stdio(false);
//	cin >> n;
//	for (int i = 1; i <= n; i++) {
//		cin >> p[i] >> q[i];
//		max < p[i] ? max = p[i] : max;
//	}
//	fi[0] = 0;
//	fi[1] = 1;
//	for (int i = 2; i <= max; i++) {
//		fi[i] = (fi[i - 1] + fi[i - 2])% 1000000000000000;
//	}
//	for (int j = 1; j <= n; j++) {
//		ans = fi[p[j]] % q[j];
//		cout << "Case #" << j << ':' << ' ' << ans << endl;
//	}
//
//	printf("%lld\n", fi[10000]);
//}

#include <iostream>
#include <algorithm>
using namespace std;

int T, P, Q, i;

long long D[2];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> T;
	for (int j = 1; j <= T; ++j) {
		cin >> P >> Q;
		P--;
		i = 0;
		D[0] = 0;
		D[1] = 1 % Q;
		cout<< D[1] << endl;
		for (; P; i = !i, --P)
			D[i] = (D[i] + D[!i]) % Q;
		cout << "Case #" << j << ": " << D[!i] << "\n";
	}
	return 0;
}