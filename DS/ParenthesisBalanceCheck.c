// Code by bevatsal1122
// Trust God, Your Code Will Work

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct node {
   char data;
   struct node *next;
};

void push(struct node **start, char data) {
   struct node *insertNode=(struct node *)malloc(sizeof(struct node));
   insertNode->data=data;
   if (*start==NULL) insertNode->next=NULL;
   else insertNode->next=*start;
  *start=insertNode;
}

void pop(struct node **start) {
   if (*start==NULL) return;
   else {
      struct node *deleteNode=*start;
      char poppedElement=deleteNode->data;
      *start=(*start)->next;
      free(deleteNode);
   }
}

char peak(struct node **start) {
   if (*start==NULL) return ' ';
   else {
      struct node *topNode=*start;
      char poppedElement=topNode->data;
      return poppedElement;
   }
}

void display(struct node *start) {
   printf("\nCurrent Stack- \n");
   while (start!=NULL) {
      printf("%c", start->data);
      start=start->next;
   }
} 

int main()
{
   struct node *top=NULL;
   char expr[100];
   int key=1;
   printf("\nEnter Expression: ");
   scanf("%s", expr);
   for (int i=0; i<strlen(expr) && key; ++i) {     
      if (expr[i]=='(') push(&top, '(');
      else if (expr[i]=='[') push(&top, '[');
      else if (expr[i]=='{') push(&top, '{');
      else if (expr[i]==')') {
         if (top!=NULL && peak(&top)=='(') pop(&top);
         else key=0;
      }
      else if (expr[i]==']') {
         if (top!=NULL && peak(&top)=='[') pop(&top);
         else key=0;
      }
      else if (expr[i]=='}') {
         if (top!=NULL && peak(&top)=='{') pop(&top);
         else key=0;

      }
   }
   printf("\n%s", (key&&top==NULL)?("Parenthesis are balanced.\n"):("Parenthesis are not balanced.\n"));
   return 0;
}
