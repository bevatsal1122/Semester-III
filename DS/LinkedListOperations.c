// Code by bevatsal1122
// Trust God, Your Code Will Work

// Sorting Integer Elements in Ascending Order

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct node {
   int data;
   struct node* next;
};

void pushAtStart(struct node **start, int data) {
   struct node *insertNode=malloc(sizeof(struct node));
   insertNode->data=data;
   if (*start==NULL) insertNode->next=NULL;
   else insertNode->next=*start;
  *start=insertNode;
}

void pushAtEnd(struct node **start, int data) {
   struct node *insertNode=malloc(sizeof(struct node));
   insertNode->data=data;
   struct node *q=*start;
   while (q->next!=NULL) q=q->next;
   q->next=insertNode;
   insertNode->next=NULL;
}

void pushInBetween(struct node **start, int data, int position) {
   struct node *insertNode=malloc(sizeof(struct node));
   insertNode->data=data;
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
      if (q->data==searchData) {
         return ++key;
      }
      q=q->next;
      key++;
   }
   return -1;
}

void display(struct node *start) {
   printf("\nCurrent Linked List- \n");
   while (start!=NULL) {
      printf("%d ", start->data);
      start=start->next;
   }
} 

int getElement(struct node *start, int position) {
   while(position--) start=start->next;
   if (start!=NULL) return start->data;
   return -1;
} 

int main()
{
   struct node *top=NULL;
   int choice, n;
   printf("\nAdd Number: ");
   scanf("%d", &n);
   pushAtStart(&top, n);
   printf("\n1. Enter More Number\n0. Exit\nEnter Choice: ");
   scanf("%d", &choice);
   while (choice) {
      struct node *p=top;
      int key=0;
      printf("\nAdd Number: ");
      scanf("%d", &n);
      while ((p->data)<n && p->next!=NULL) {
         key++;
         p=p->next;
      }
      struct node *t=top;
      while (t->next!=NULL) t=t->next;
      
      if (p==top) {
         if (p->next!=NULL || (p->data)>=n) pushAtStart(&top, n);
         else pushAtEnd(&top, n);
      }
      else if (p->next==NULL && (p->data)<n) {
         pushAtEnd(&top, n);
      }
      else {
         pushInBetween(&top, n, key);
      }

      printf("\n1. Enter More Number\n0. Exit\nEnter Choice: ");
      scanf("%d", &choice);
   }
   display(top);
   return 0;
}
