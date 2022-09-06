package Queues;

public class Queues {
    private int front;
    private int rear;
    private int array[];
    private int capacity;

    public Queues(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        front = 0;
        rear = -1;
    }

    public boolean isFull(){
        return rear == capacity-1;
    }

    public boolean isEmpty(){
        return front>=rear;
    }

    public void enqueue(int data){
        if(!isFull()){
            array[++rear] = data;
        }
        else
        {
            System.out.println("OverFlow");
        }
    }

    public int dequeue(){
        if(!isEmpty()){
            return array[front++];
        }
        else return -1;
    }

    public int queueFront(){
        return array[front];
    }

    public int queueRear(){
        return array[rear];
    }

    public void displayQueue(){
        if(!isEmpty()) {
            int x = front;
            while (x <= rear) {
                System.out.print(array[x++] + " ");
            }
            System.out.println("");
        }
    }

    public void makeEmpty(){
        front = 0;
        rear = -1;
    }

}

class Main{
    public static void main(String[] args) {
        Queues q = new Queues(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.displayQueue();
        q.enqueue(5);
        q.enqueue(6);
        q.displayQueue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.enqueue(7);
        q.enqueue(8);
        q.displayQueue();
        q.makeEmpty();
        q.displayQueue();

    }

}
