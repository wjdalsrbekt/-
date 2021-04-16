#include <iostream>
#include <algorithm>

using namespace std;

int letter_Num[26] = { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1 ,-1,-1,-1,-1,-1 ,-1,-1,-1,-1,-1 ,-1};//memset ��� ���; ����
char S_char[26]; //���������� �ʱ�ȭ ������ ����Ұ�.
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string S;
	cin >> S;
	
	for (int i = 0; i < S.length(); i++) {
		S_char[i] = S[i]; //next permutation�� �������� String���� char��ȯ Ʋ�ȴ� ����1�� ��Ծ����� nextpermutation ���� �б�
		letter_Num[S_char[i] - 97] = i; //��ȣ�ֱ� //��ȣ�� �ִ� ������ ���ĺ� ������� ������ ã������
	}
	string S_ans; //Ʋ�ȴ����� 1��. nextletter���ϱ� ���ؼ�.
	if (S.length() < 26) 
	{
		S_ans = S; //������ ���ڸ� �߰��Ҷ��� char�� ���ڿ����� string���� ���ϴ°� ���ϴ�.
		for (int i = 0; i < 26; i++)
		{
			if (letter_Num[i] == -1)
			{
				char next_Letter = (i + 97); // �ҹ��� a  �ƽ�Ű�ڵ� ���� ���ؼ�, ���� ������ ���ڸ� �߰��ϱ�����
				S_ans = S_ans + next_Letter;
				break;
			}
		}
		cout << S_ans << endl;
	}
	else if (S.length() == 26){
		if (next_permutation(S_char, S_char + 27) == true) //���� ���ڿ� ���ϱ�
		{
			cout << S_char << endl;
		}
		else cout << -1 << endl; //���̻� ����� ���� ������ ����ϴ� ��
	}
	return 0;
}