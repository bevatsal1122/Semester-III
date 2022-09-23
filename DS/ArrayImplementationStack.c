#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>

void push(char stack[], int *top, char element) {
   (*top)++;
   stack[*top]=element;
}

void pop(char stack[], int *top) {
   if (*top==-1) {
      printf("\nStack Underflow\n");
      return;
   }
   stack[(*top)--]='\0';
}

void peek(char stack[], int *top) {
   if (*top==-1) {
      printf("\nStack Underflow\n");
      return;
   }
   printf("\n%c\n", stack[*top]);
}

void display(char stack[], int *top) {
   printf("\n");
   for (int i=*top; i>=0; --i) {
      printf("%c\n", stack[i]);
   }
}

int main() {
   int n, top=-1, choice;
   printf("\nEnter Maximum Size of Stack: ");
   scanf("%d", &n);
   char stack[n];
   printf("\nOptions-\n1. Push\n2. Pop\n3. Peek\n4. Display\n5. Exit\nChoice: ");
   scanf("%d", &choice);
   while (choice!=5) {
      if (choice==1) {
         if (top+1>=n) {
            printf("\nStack Overflow\n");
         }
         else {
            char x;
            printf("\nEnter Element for Addition: ");
            fflush(stdin);
            scanf("%c", &x);
            push(stack, &top, x);
         }
      }
      else if (choice==2) pop(stack, &top);
      else if (choice==3) peek(stack, &top);
      else if (choice==4) display(stack, &top);
      else if (choice!=5) printf("\nWrong Option Entered!!");
      printf("\nOptions-\n1. Push\n2. Pop\n3. Peek\n4. Display\n5. Exit\nChoice: ");
      scanf("%d", &choice);
   }
   printf("\nExiting...\n");
   return 0;
}
