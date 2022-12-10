#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct node {
   char name[100];
   int age, disability, priority;
   struct node* next;
};

void pushAtStart(struct node **start, char name[], int age, int disability, int priority) {
   struct node *insertNode=malloc(sizeof(struct node));
   insertNode->age=age;
   insertNode->disability=disability;
   insertNode->priority=priority;
   strcpy(insertNode->name, name);
   if (*start==NULL) insertNode->next=NULL;
   else insertNode->next=*start;
  *start=insertNode;
}

void pushInBetween(struct node **start, char name[], int age, int disability, int priority, int position) {
   if (position==0) {
      pushAtStart(start, name, age, disability, priority);
      return;
   }
   struct node *insertNode=malloc(sizeof(struct node));
   insertNode->age=age;
   insertNode->disability=disability;
   insertNode->priority=priority;
   strcpy(insertNode->name, name);
   struct node *q=*start;
   position--;
   while(position--) q=q->next;
   insertNode->next=q->next;
   q->next=insertNode;
}

int search(struct node *start, int searchData) {
   int key=-1;
   struct node *q=start;
   while (q!=NULL) {
      if (q->age==searchData) {
         return ++key;
      }
      q=q->next;
      key++;
   }
   return -1;
}

void display(struct node *start) {
   printf("\nServicing Order (Adjusted according to Priority Queue, To be removed from top) - \n");
   while (start!=NULL) {
      printf("%s", start->name);
      printf("\tAge: %d ", start->age);
      if (start->disability) printf("\tDisabled");
      else printf("\t");
      if (start->age>=60) printf("\tSenior Citizen");
      printf("\n");
      start=start->next;
   }
} 

int main()
{
   struct node *top=NULL;
   int choice;
   printf("\nEnter 1 for Yes & 0 for No\nAdd Person ?? ");
   scanf("%d", &choice);
   while (choice) {
      int age, disabled, priority=0, position=0;
      char name[1000];
      printf("\nAdd Person Name: ");
      scanf("%s", name);
      printf("Add Person Age: ");
      scanf("%d", &age);
      printf("\nEnter 1 for Yes & 0 for No\nIs Person disabled ?? ");
      scanf("%d", &disabled);
      if (disabled==1 && age>=60) priority=3;
      else if (disabled==1) priority=2;
      else if (age>=60) priority=1;
      struct node *start=top;
      while (start!=NULL && priority<=start->priority) {
         position++;
         start=start->next;
      }
      pushInBetween(&top, name, age, disabled, priority, position);
      printf("\nEnter 1 for Yes & 0 for No\nAdd Person ?? ");
      scanf("%d", &choice);
   }
   display(top);
   return 0;
}
