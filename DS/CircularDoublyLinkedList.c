#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct node {
   struct node* prev;
   int data;
   struct node* next;
};

void pushAtStart(struct node **start, struct node **end, int data) {
   struct node *insertNode=malloc(sizeof(struct node));
   insertNode->data=data;
   if (*start==NULL) {
      insertNode->next=insertNode;
      *end=insertNode;
      insertNode->prev=insertNode;
   }
   else {
      (*start)->prev=insertNode;
      insertNode->next=*start;
      insertNode->prev=*end;
   }
   *start=insertNode;
}

void deleteAtStart(struct node **start, struct node **end) {
   struct node *q=*start;
   printf("\nDeleted Element: %d\n", q->data);
   if (q==*end) {
      *start=NULL;
      *end=NULL;
   }
   else {
      (q->next)->prev=q->prev;
      *start=q->next;
   }
   free(q);
}

void pushAtEnd(struct node **start, struct node **end, int data) {
   struct node *insertNode=malloc(sizeof(struct node));
   insertNode->data=data;
   struct node *q=*end;
   insertNode->next=q->next;
   if (q!=NULL) q->next=insertNode;
   else *start=insertNode;
   insertNode->prev=q;
   *end=insertNode;
}

void deleteAtEnd(struct node **start, struct node **end) {
   struct node *q=*end;
   printf("\nDeleted Element: %d\n", q->data);
   if (q==*start) {
      *start=NULL;
      *end=NULL;
   }
   else {
      (q->prev)->next=q->next;
      *end=q->prev;
   }
   free(q);
}

void display(struct node *start, struct node *end) {
   printf("\nCurrent Doubly Linked List- \n");
   while (start!=end) {
      printf("%d ", start->data);
      start=start->next;
   }
   if (end!=NULL) printf("%d", end->data);
   printf("\n");
} 

void revDisplay(struct node *start, struct node *end) {
   printf("\nCurrent Doubly Linked List (Reversed)- \n");
   while (end!=start) {
      printf("%d ", end->data);
      end=end->prev;
   }
   if (start!=NULL) printf("%d", start->data);
   printf("\n");
}

int main()
{
   struct node *top=NULL;
   struct node *last=NULL;
   int length=0, choice;
   printf("\nOptions-\n1. Insert Element at Start\n2. Insert Element at End\n3. Display CDLL\n4. Reverse Display CDLL\n5. Delete Element at Start\n6. Delete Element at End\n7. Exit\n\nChoice: ");
   scanf("%d", &choice);
   while (choice!=7) {
      if (choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=5 && choice!=6) printf("\nWrong Option Entered!!\n");
      else if (choice==1 || choice==2) {
         int n;
         printf("\nEnter Number: ");
         scanf("%d", &n);
         if (choice==1) pushAtStart(&top, &last, n);
         else if (choice==3) pushAtEnd(&top, &last, n);
         length++;
         display(top, last);
      }
      else if (choice==3) display(top, last);
      else if (choice==4) revDisplay(top, last);
      else if (choice==5 || choice==6) {
         if (length<=0) printf("\nEmpty CDLL!!\n");
         else {
            if (choice==5) deleteAtStart(&top, &last); 
            if (choice==6) deleteAtEnd(&top, &last); 
            length--;
            display(top, last);
         }
      } 
      printf("\nOptions-\n1. Insert Element at Start\n2. Insert Element at End\n3. Display CDLL\n4. Reverse Display CDLL\n5. Delete Element at Start\n6. Delete Element at End\n7. Exit\n\nChoice: ");
      scanf("%d", &choice);
   }
   while (top!=last) {
      struct node* q=top;
      top=top->next;
      free(q);
   }
   free(top);
   printf("\nExiting...\n");
   return 0;
}
