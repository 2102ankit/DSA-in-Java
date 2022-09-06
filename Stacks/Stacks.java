package Stacks;

public class Stacks {
    private int capacity;
    private int array[];
    private int top;

    //create a stack
    public Stacks(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        top =-1;
    }

    //push an element into stack
    public void push(int data){
        if(isFull()){
            System.out.println("Stack OverFlow");
        }
        else{
            array[++top]=data;
        }
    }

    //check if stack full / empty
    private boolean isFull() {
        return top==capacity-1;
    }

    private boolean isEmpty() {
        return top==-1;
    }

    //peek element at top of stack
    public int stackTop(){
        return array[top];
    }

    //pop element out of array
    public int pop(){
        if(!isEmpty()){
            return array[top--];
        }
        else {
            System.out.println("Stack UnderFlow");
            return -1;
        }
    }

    //make stack empty
    public void makeEmpty(){
        top=-1;
    }

    public void displayStack(){
        int x = top;
        while(x!=-1){
            System.out.println(array[x--]);
        }
    }

}

class Main{
    public static void main(String[] args) {
        Stacks st = new Stacks(5);

        st.pop();
        st.displayStack();
        System.out.println("------------------------------");
        st.push(1);
        st.push(2);
        st.push(3);
        st.pop();
        st.displayStack();
        System.out.println("------------------------------");
        st.push(4);
        st.push(5);
        st.displayStack();
        System.out.println("------------------------------");
        st.push(6);
        st.push(7);
        st.displayStack();
        System.out.println("------------------------------");
        st.pop();
        st.push(8);
        st.makeEmpty();
        st.displayStack();
    }
}

