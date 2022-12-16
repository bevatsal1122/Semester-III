#include<bits/stdc++.h>
#include<string>
using namespace std;

void linear_probing(int arr[], int n, int num, int &collisions) {
   int target=num%n;
   while (arr[target]!=-1) {
      target=(target+1)%n;
      ++collisions;
      cout<<"Collision occured at index "<<target<<"\n";
   }
   arr[target]=num;
}

void quadratic_probing(int arr[], int n, int num, int &collisions) {
   int target=num%n, rock=target, i=0;
   while (arr[rock]!=-1) {
      rock=(target+(++i*i))%n;
      ++collisions;
      cout<<"Collision occured at index "<<rock<<"\n";
   }
   arr[rock]=num;
}

int search_linear_probing(int arr[], int n, int num) {
   int target=num%n, ups=0;
   while (arr[target]!=num && ++ups<n) target=(target+1)%n;
   if (arr[target]==num) return target;
   return -1;
}

int search_quadratic_probing(int arr[], int n, int num) {
   int target=num%n, rock=target, i=0, ups=0;
   while (arr[rock]!=num && ++ups<n) rock=(target+(++i*i))%n;
   if (arr[rock]==num) return rock;
   return -1;
}

int main()
{
   int N, choice, sChoice, collisions=0;
   cout<<"\n1. Linear Probing\n2. Quadratic Probing\nEnter Choice: ";
   cin>>choice;
   while (choice!=1 && choice!=2) {
      cout<<"\nWrong Option!!\n\n1. Linear Probing\n2. Quadratic Probing\nEnter Choice: ";
      cin>>choice;
   }
   cout<<"\nEnter N: ";
   cin>>N;
   int data[N];
   for (int i=0; i<N; ++i) data[i]=-1;
   cout<<"\n";
   for (int i=0; i<N; ++i) {
      int num;
      cout<<"Enter Element "<<i+1<<": ";
      cin>>num;
      if (choice==1) linear_probing(data, N, num, collisions);
      else if (choice==2) quadratic_probing(data, N, num, collisions);
   }
   cout<<"\nTotal No. of Collisions: "<<collisions<<"\nHash Table -\n";
   for (int i=0; i<N; ++i) cout<<data[i]<<"\n";
   cout<<"\nEnter -1 to abort\nEnter Value (To Search): ";
   cin>>sChoice;
   while (sChoice!=-1) {
      int found;
      if (choice==1) found=search_linear_probing(data, N, sChoice);
      else if (choice==2) found=search_quadratic_probing(data, N, sChoice);
      cout<<(found!=-1?("Element found at "+to_string(found+1)+" position...\n"):("Element not found...\n"));
      cout<<"\nEnter -1 to abort\nEnter Value (To Search): ";
      cin>>sChoice;
   }
   cout<<"\nExiting...\n";
   return 0;
}
