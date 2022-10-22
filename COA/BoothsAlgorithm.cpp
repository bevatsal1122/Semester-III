#include<bits/stdc++.h>
using namespace std;

int convertToDecimal (int binary[], int length) {
	int decimal=0;
	for (int i=length-1; i>=0; --i) {
		decimal+=binary[i]*pow(2, length-i-1);
	}
	return decimal;
}

void convertToBinary (int decimal, int binary[]) {
	int x=3;
	while (decimal>0 && x>=0) {
		binary[x--]=decimal%2;
		decimal/=2;
	}
}

void twosComplement(int binary[], int tc[], int length) {
	for (int i=0; i<length; ++i) binary[i]?tc[i]=0:tc[i]=1;
	int carry=0, k=length-1;
	tc[k]+=1;
	do {
		tc[k]+=carry;
		carry=0;
		if (tc[k]==3) {carry=1; tc[k]=1;}
		else if (tc[k]==2) {carry=1; tc[k]=0;}
	}
	while (carry && k--);
}

void addBinary(int a[], int b[]) {
	int carry=0;
	for (int i=3; i>=0; --i) {
		a[i]+=b[i]+carry;
		carry=0;
		if (a[i]==3) {carry=1; a[i]=1;}
		else if (a[i]==2) {carry=1; a[i]=0;}
	}
}

void arithmeticRightShift(int a[], int q[], int *q1) {
	int t=a[3];
	*q1=q[3];
	for (int i=3; i>=1; --i) a[i]=a[i-1];
	for (int i=3; i>=1; --i) q[i]=q[i-1];
	q[0]=t;
}

int main()
{
	int x, y;
	cout<<"\nBooths Algorithm for 4 Bits including Sign Bit\nRange: [-7, 7]\nEnter Multiplicand (Q): "; cin>>x;
	cout<<"Enter Multiplier (M): "; cin>>y;
	int m[4] {}, m2[4] {}, q[4] {}, a[4] {};
	int n=4, q1=0;
	if (x>=8 || y>=8 || x<-7 || y<-7) {cout<<"\nOut of Scope!!\n"; return 0;}
	if (x<0) {
		int t[4] {};
		convertToBinary(abs(x), t);
		twosComplement(t, q, 4);
	}
	else convertToBinary(x, q);
	if (y<0) {
		int t[4] {};
		convertToBinary(abs(y), t);
		twosComplement(t, m, 4);
	}
	else convertToBinary(y, m);

	twosComplement(m, m2, 4);
	cout<<"\n("<<x<<")*("<<y<<")="<<x*y<<"\n";
	cout<<"\nQ : ";
	for (int i=0; i<4; ++i) cout<<q[i];
	cout<<"\nM : ";
	for (int i=0; i<4; ++i) cout<<m[i];
	cout<<"\nM'2 : ";
	for (int i=0; i<4; ++i) cout<<m2[i];
	cout<<"\n\n A \t Q \t Q1\tn\n---------------------------\n";

	for (int i=0; i<4; ++i) cout<<a[i];
	cout<<"\t";
	for (int i=0; i<4; ++i) cout<<q[i];
	cout<<"\t "<<q1<<"\t"<<n<<"\n";

	while (n--) {
		bool key=true;
		if (q[3]==0 && q1==1) addBinary(a, m);
		else if (q[3]==1 && q1==0) addBinary(a, m2);
		else key=false;

		if (key) {
			for (int i=0; i<4; ++i) cout<<a[i];
			cout<<"\t";
			for (int i=0; i<4; ++i) cout<<q[i];
			cout<<"\t "<<q1<<"\t"<<n+1<<"\n\n";
		}
		else cout<<"\n";

		arithmeticRightShift(a, q, &q1);

		for (int i=0; i<4; ++i) cout<<a[i];
		cout<<"\t";
		for (int i=0; i<4; ++i) cout<<q[i];
		cout<<"\t "<<q1<<"\t"<<n<<"\n";
	}

	int result[8] {};
	for (int i=0; i<4; ++i) result[i]=a[i];
	for (int i=4; i<8; ++i) result[i]=q[i-4];

	cout<<"\n\nResult: (";
	for (int i=0; i<8; ++i) cout<<result[i];
	cout<<") [Binary Number]";
	if (x*y<0) {
		int tc[8] {};
		twosComplement(result, tc, 8);
		cout<<"\nHence, the Decimal Number Equivalent is -"<<convertToDecimal(tc, 8)<<".\n";
	}
	else cout<<"\nHence, the Decimal Number Equivalent is "<<convertToDecimal(result, 8)<<".\n";

	return 0;
}
