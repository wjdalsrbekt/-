//1) d[n]=d[n/3]+1
//2) d[n]=d[n/2]+1
//3) d[n]=d[n-1]+1

//top down - 재귀 
#include <bits/stdc++.h>
using namespace std;
int d[1000001];
int make_one(int n);
int main() {
	int n;
	int ans;
	scanf("%d", &n);
	ans=make_one(n);
	printf("%d", ans);

}

int make_one(int n) {
	if (n == 1) return 0;
	if (d[n] > 0) return d[n];
	d[n] = make_one(n-1) + 1;
	if (n % 2 == 0) {
		int tmp = make_one(n / 2) + 1;
		d[n] = d[n] > tmp ? tmp : d[n];
	}
	if (n % 3 == 0)
	{
		int tmp = make_one(n / 3) + 1;
		d[n] = d[n] > tmp ? tmp : d[n];
	}
	return d[n];
}
//다른 방식
/*
* //1) d[n]=d[n/3]+1
//2) d[n]=d[n/2]+1
//3) d[n]=d[n-1]+1

#include <bits/stdc++.h>
using namespace std;
int d[1000001];
int make_one(int n);
int main() {
	int n;
	int ans;
	scanf("%d", &n);
	ans=make_one(n);
	
	printf("%d", ans);

}

int make_one(int n) {
	if (n == 1) return 0;
	if (d[n] > 0) return d[n];
	d[n] = make_one(n-1) + 1;
	if (n % 2 == 0) {
		int tmp = make_one(n / 2) + 1;
		if (d[n] > tmp)d[n] = tmp;
	}
	if (n % 3 == 0) {
		int tmp = make_one(n / 3) + 1;
		if (d[n] > tmp)d[n] = tmp;
	}
	return d[n];
}
* 
*/