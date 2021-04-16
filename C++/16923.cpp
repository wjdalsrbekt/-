#include <iostream>
#include <algorithm>

using namespace std;

int letter_Num[26] = { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1 ,-1,-1,-1,-1,-1 ,-1,-1,-1,-1,-1 ,-1};//memset 방법 기억; 망할
char S_char[26]; //전역변수로 초기화 한이유 기억할것.
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string S;
	cin >> S;
	
	for (int i = 0; i < S.length(); i++) {
		S_char[i] = S[i]; //next permutation을 쓰기위해 String에서 char변환 틀렸던 이유1번 까먹었으면 nextpermutation 문서 읽기
		letter_Num[S_char[i] - 97] = i; //번호넣기 //번호를 넣는 이유는 알파벳 순서대로 유무를 찾기위해
	}
	string S_ans; //틀렸던이유 1번. nextletter더하기 위해서.
	if (S.length() < 26) 
	{
		S_ans = S; //나머지 숫자를 추가할때는 char의 문자열보다 string에서 더하는게 편하다.
		for (int i = 0; i < 26; i++)
		{
			if (letter_Num[i] == -1)
			{
				char next_Letter = (i + 97); // 소문자 a  아스키코드 값만 더해서, 다음 순서의 글자를 추가하기위해
				S_ans = S_ans + next_Letter;
				break;
			}
		}
		cout << S_ans << endl;
	}
	else if (S.length() == 26){
		if (next_permutation(S_char, S_char + 27) == true) //다음 문자열 구하기
		{
			cout << S_char << endl;
		}
		else cout << -1 << endl; //더이상 출력할 것이 없을때 출력하는 것
	}
	return 0;
}