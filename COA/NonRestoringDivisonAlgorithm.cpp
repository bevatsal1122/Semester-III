#include<bits/stdc++.h>
using namespace std;

int convertToDecimal (int binary[], int length) {
	int decimal=0;
	for (int i=length-1; i>=0; --i) {
		decimal+=binary[i]*pow(2, length-i-1);
	}
	return decimal;
}

void convertToBinary (int decimal, int binary[], int length) {
	int x=length-1;
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

void leftShift(int a[], int q[]) {
	for (int i=0; i<=2; i++) a[i]=a[i+1];
   a[3]=q[0];
	for (int i=0; i<=2; i++) q[i]=q[i+1];
}

int main()
{
	int x, y;
	cout<<"\nNon Restoring Division Algorithm for 4 Bits including Sign Bit\nRange: [-7, 7]\nEnter Dividend (Q): "; cin>>x;
	cout<<"Enter Divisor (M): "; cin>>y;

	if (x>=8 || y>=8 || x<0 || y<=0) {cout<<"\nOut of Scope!!\n"; return 0;}

   int q[4] {}, m[4] {}, m2[4] {}, a[4] {};
	int n=4;
   
	convertToBinary(x, q, 4);
	convertToBinary(y, m, 4);
   twosComplement(m, m2, 4);

	cout<<"\nFor "<<x<<"/"<<y<<",\nQuotient: "<<(int)(x/y)<<"\nRemainder: "<<y<<"\n";
   cout<<"\nQ: ";
   for (int i=0; i<4; ++i) cout<<q[i];
   cout<<"\nM: ";
   for (int i=0; i<4; ++i) cout<<m[i];
	cout<<"\nM'2: ";
   for (int i=0; i<4; ++i) cout<<m2[i];
   cout<<"\n\n A \t Q \t n\n--------------------\n";

	for (int i=0; i<4; ++i) cout<<a[i];
	cout<<"\t";
	for (int i=0; i<4; ++i) cout<<q[i];
	cout<<"\t "<<n<<"\n";

   while (n--) {
      if (a[0]==1) {
         leftShift(a, q);
         addBinary(a, m);
      }
      else if (a[0]==0) {
         leftShift(a, q);
         addBinary(a, m2);
      }

		for (int i=0; i<4; ++i) cout<<a[i];
		cout<<"\t";
		for (int i=0; i<3; ++i) cout<<q[i];
		cout<<"_";
		cout<<"\t "<<n+1<<"\n\n";

		if (a[0]==1) q[3]=0;
		else if (a[1]==0) q[3]=1;

		for (int i=0; i<4; ++i) cout<<a[i];
		cout<<"\t";
		for (int i=0; i<4; ++i) cout<<q[i];
		cout<<"\t "<<n<<"\n";
   }

   if (a[0]==1) addBinary(a, m);

	cout<<"\n\nQuotient: (";
	for (int i=0; i<4; ++i) cout<<q[i];
	cout<<") [Binary Number]\nHence, the Decimal Number Equivalent is "<<convertToDecimal(q, 4)<<".\n";
	cout<<"\nRemainder: (";
	for (int i=0; i<4; ++i) cout<<a[i];
	cout<<") [Binary Number]\nHence, the Decimal Number Equivalent is "<<convertToDecimal(a, 4)<<".\n";
	return 0;
}
