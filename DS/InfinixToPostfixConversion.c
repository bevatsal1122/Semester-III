// Code by bevatsal1122
// Trust God, Your Code Will Work

#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>

void push(char stack[], int *top, char element) {
   (*top)++;
   stack[*top]=element;
}

char pop(char stack[], int *top) {
   if (*top==-1) {
      printf("\nStack Underflow\n");
      return ' ';
   }
   char element=stack[(*top)];
   stack[(*top)--]='\0';
   return element;
}

char peek(char stack[], int *top) {
   if (*top==-1) return ' ';
   return stack[*top];
}

void display(char stack[], int *top) {
   printf("\n");
   for (int i=*top; i>=0; --i) {
      printf("%c\n", stack[i]);
   }
}

int main() {
   char expr[300], res[300], stack[200];
   int top=-1, key=-1;
   printf("\nEnter Expression: ");
   scanf("%s", expr);
   for (int i=0; i<strlen(expr); ++i) {
      if (isdigit(expr[i]) || isalpha(expr[i])) {
         key++;
         res[key]=expr[i];
      }
      else if (expr[i]=='^') {
         while(top!=-1 && peek(stack, &top)=='^') {
            key++;
            res[key]=pop(stack, &top);
         }
         push(stack, &top, expr[i]);
      }
      else if (expr[i]=='*' || expr[i]=='/') {
         while(top!=-1 && (peek(stack, &top)=='*' || peek(stack, &top)=='/' || peek(stack, &top)=='^')) {
            key++;
            res[key]=pop(stack, &top);
         }
         push(stack, &top, expr[i]);
      }
      else if (expr[i]=='+' || expr[i]=='-') {
         while(top!=-1 && (peek(stack, &top)=='*' || peek(stack, &top)=='/' || peek(stack, &top)==expr[i] || peek(stack, &top)=='^')) {
            key++;
            res[key]=pop(stack, &top);
         } 
         push(stack, &top, expr[i]);  
      }
      else if (expr[i]=='(') {
         push(stack, &top, expr[i]);  
      }
      else if (expr[i]==')') {
         int k=0;
         while((top!=-1 && peek(stack, &top)!='(')) {
            key++;
            res[key]=pop(stack, &top);
         } 
         char dump=pop(stack, &top);
      }
   }

   while (top>=0) {
      key++;
      res[key]=pop(stack, &top);
      top--;
   }
   printf("\nInfinix Expression: %s", expr);
   printf("\nPostfix Expression: ");
   for (int i=0; i<=key; ++i) printf("%c", res[i]);
   printf("\n");
   return 0;
}
