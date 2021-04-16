#include <cstdio>
#include <string>

using namespace std;

/*
 1,2,3 Ãß°¡
 1) memory[n]+=memory[n-1]
 2) memory[n]+=memory[n-2]
 3) memory[n]+=memory[n-3]

*/
long long memory[10000001];
int main() {
	int n,m;
	memory[1] = 1;
	memory[2] = 2;
	memory[3] = 4;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &m);
		/*memset(memory, 0, sizeof(memory));
		memory[1] = 1;
		memory[2] = 2;
		memory[3] = 4;*/
		for (int j = 4; j <= m; j++) {
			memory[j] = (memory[j - 1] + memory[j - 2] + memory[j - 3])% 1000000009;
		}
		printf("%d\n", memory[m]);
	}

}