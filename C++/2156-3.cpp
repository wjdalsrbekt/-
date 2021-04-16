/*
* top down 하향식 재귀
* 
* 0번 연속 : d[n] = d[n-1]
* 1번 연속 : d[n] = d[n-2] + a[n]
* 2번 연속 : d[n] = d[n-3] + a[n] + a[n-1]
* 
*/

#include <iostream>
#include <algorithm>

using namespace std;

int n;
int arr[10001];
int dp[10001][3];
int result;

int f(int n, int state)
{
    if (n <= 0) return 0;
    if (dp[n][state]) return dp[n][state];

    if (state == 0) return dp[n][state] = max(f(n - 1, 0), max(f(n - 1, 1), f(n - 1, 2)));
    else if (state == 1) return dp[n][state] = f(n - 1, 0) + arr[n];
    else return dp[n][state] = f(n - 1, 1) + arr[n];
}

int main()
{
    cin.tie(0);
    ios::sync_with_stdio(false);

    cin >> n;

    for (int i = 1; i <= n; i++) cin >> arr[i];

    result = max(f(n, 0), max(f(n, 1), f(n, 2)));

    cout << result;

    return 0;
    
}