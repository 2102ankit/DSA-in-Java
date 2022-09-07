package Exp1;
//infix to prefix --> Polish Notation

import java.util.Scanner;
class Stack {
    private int capacity;
    public char array[];
    private int top;

    public Stack(int capacity) {
        this.capacity = capacity;
        array = new char[capacity];
        top =-1;
    }

    public void push(char data){
        array[++top]=data;
    }

    public boolean isEmpty() {
        return top==-1;
    }

    public char peek(){
        if(!isEmpty())
            return array[top];
        return 0;
    }

    public char pop(){
        if(!isEmpty())
            return array[top--];
        return 0;
    }

    public void displayStack(){
        System.out.println("-- Displaying Stack --");
        int x = top;
        while(x!=-1){
            System.out.println(array[x--]);
        }
    }
}

class Polish{

    public static void solve(String str){
        char[] ch = str.toCharArray();
        int n =str.length();
        Stack st = new Stack(n);
        String sol = "";

        for(int i=n-1; i>=0; i--){

            if(ch[i]>=97 && ch[i]<=122){
                sol+=ch[i];
            }// add operands

            if(ch[i]==')'){
                st.push(ch[i]);
            }
            else if(ch[i]=='('){
                while(st.peek()!= ')'){
                    sol+=st.pop();
                }
                st.pop();
            }// takes care of brackets
            //if incoming is ^ and top has */+- then higher precedence
            //if incoming is any +-/* and top has +- then higher or equal precedence
            if (    ((ch[i]== '+' || ch[i] == '-' || ch[i] == '*' || ch[i] == '/') && (st.peek() == '+' || st.peek() == '-' || st.peek() == ')' || st.isEmpty())   )//+- have lower or equal precedence
                    || (    (ch[i] == '*' || ch[i] == '/') && (st.peek() == '*' || st.peek() == '/' || st.peek() == ')' || st.isEmpty())    ) //same precedence
                    || ( ch[i]=='^' && (st.peek() == '^' ||st.peek() == '+' || st.peek() == '-' || st.peek() == '*' || st.peek() == '/' || st.peek() == ')' || st.isEmpty())) // all have lower or equal precendece than ^
             ){
                st.push(ch[i]);
            }

            if (((ch[i] == '+' || ch[i] == '-') && (st.peek() == '*' || st.peek() == '/')) || ((ch[i] == '*' || ch[i] == '/') && st.peek()=='^') ) {
                while (!st.isEmpty()) {
                    sol+= st.pop();
                }
                st.push(ch[i]);
            }
        }// end loop

        while(!st.isEmpty()){
            sol+= st.pop();
        }

        String ans = "";
        for (int i=0; i<sol.length(); i++)
        {   char c = sol.charAt(i);
            ans = c+ans;
        }
        System.out.println(ans);
    }// end solve

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String s  = sc.nextLine();
        solve(s);
    }
}




