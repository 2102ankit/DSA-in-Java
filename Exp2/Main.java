package Exp2;
import java.util.Scanner;
class Queue{
    int front, rear, size, no;
    int array[]; //-- replace this by

    public Queue (int size, int front, int rear, int[] array){
        this.array = array;
        this.size = size;
        this.front  = front;
        this.rear = rear;
        this.no =0;
    }

    public boolean isFull(){
        return this.no == this.size;
    }

    public boolean isEmpty(){
        return this.no == 0;
    }

    public void enqueue(int data){
        if(!this.isFull()){
            this.array[++this.rear] = data;
            this.no++;
        }
        else
        {
            System.out.println("OverFlow");
        }
    }

    public int dequeue(){
        if(!this.isEmpty()){
            this.no--;
            return this.array[this.front++];
        }
        else{
            System.out.println("UnderFlow");
            return -1;// considering only positive inputs entered
        }
    }

    //fn for diplaying whole queue
    public void displayQueue(){
        if(this.isEmpty()){
            System.out.println("Queue Empty");
        }
        else {
            int x = this.front;
            while (x <= this.rear) {
                System.out.print(this.array[x++] + " ");
            }
            System.out.println("");
        }
    }

    public void display(){
        for(int i=0; i<size; i++){
            System.out.print(this.array[i++] + " ");
        }
        System.out.println("");

    }

}
/*
class Main{
    public static void main(String[] args){
        /* let array size be x and no of queues be y, so size of each array is x//y eg 25/3 =8
        array of queue objects thru loop q1, q2, q3
        i = 0, j = -1
        q1(8,i,j, array )
        q2(8, i+size, j+size, array)
        enq or deq ke liye q[0].enq or say q[2].deq




        int[] array = new int[25];
        // array of 25 and 5 each
        // 0 1 2 3 4    5 6 7 8 9    10 11 12 13 14   15 16 17 18 19    20 21 22 23 24
        Queue q1 = new Queue(5,0, -1, array);
        Queue q2 = new Queue(5,5,4, array);
        Queue q3 = new Queue(5,10,9,array);
        Queue q4 = new Queue(5,15,14,array);
        Queue q5 = new Queue(5,20,19,array);
        display(q1, q2, q3, q4, q5);
        Scanner sc = new Scanner(System.in);
        int x = 1;
        while(x!=0){
            System.out.println("Enter your choice of action.\n1.Enqueue\n2.Dequeue\n3.Display\n0.Exit");
            x = sc.nextInt();
            switch(x){
                case 1: {
                    System.out.println("Enter Queue number.\n1.First\n2.Second\n3.Third\n4.Fourth\n5.Fifth");
                    int y = sc.nextInt();
                    if (y == 1)    {System.out.println("Enter data to Enqueue.");
                        int data = sc.nextInt();
                        q1.enqueue(data);
                        display(q1,q2,q3,q4,q5);}
                    else if (y == 2){System.out.println("Enter data to Enqueue.");
                        int data = sc.nextInt();
                        q2.displayQueue();
                        q2.enqueue(data);
                        q2.displayQueue();
                        display(q1,q2,q3,q4,q5);}
                    else if (y == 3){System.out.println("Enter data to Enqueue.");
                        int data = sc.nextInt();
                        q3.enqueue(data);
                        display(q1,q2,q3,q4,q5);}
                    else if (y == 4){System.out.println("Enter data to Enqueue.");
                        int data = sc.nextInt();
                        q4.enqueue(data) ;
                        display(q1,q2,q3,q4,q5);}
                    else if (y == 5){System.out.println("Enter data to Enqueue.");
                        int data = sc.nextInt();
                        q5.enqueue(data) ;
                        display(q1,q2,q3,q4,q5);}
                    break;
                }
                case 2: {
                    System.out.println("Enter Queue number.\n1.First\n2.Second\n3.Third\n4.Fourth\n5.Fifth");
                    int y = sc.nextInt();
                    if (y == 1)     { q1.dequeue();display(q1,q2,q3,q4,q5);}
                    else if (y == 2){ q2.dequeue();display(q1,q2,q3,q4,q5);}
                    else if (y == 3){ q3.dequeue();display(q1,q2,q3,q4,q5);}
                    else if (y == 4){ q4.dequeue();display(q1,q2,q3,q4,q5);}
                    else if (y == 5){ q5.dequeue();display(q1,q2,q3,q4,q5);}
                    break;
                }
                case 3: {
                    System.out.println("Enter Queue number.\n1.First\n2.Second\n3.Third\n4.Fourth\n5.Fifth");
                    int y = sc.nextInt();
                    if (y == 1)     { q1.displayQueue();display(q1,q2,q3,q4,q5);}
                    else if (y == 2){ q2.displayQueue();display(q1,q2,q3,q4,q5);}
                    else if (y == 3){ q3.displayQueue();display(q1,q2,q3,q4,q5);}
                    else if (y == 4){ q4.displayQueue();display(q1,q2,q3,q4,q5);}
                    else if (y == 5){ q5.displayQueue();display(q1,q2,q3,q4,q5);}
                    break;
                }
                case 0: {
                    System.out.println("Thank You!");
                    x = 0;
                    break;
                }

            }// end switch

        }// end while loop
    }
    //fn for diplaying whole queue
    public static void display(Queue q1, Queue q2, Queue q3, Queue q4, Queue q5 ){
        System.out.println("------------------------------------------------------------------");
        q1.displayQueue();
        q2.displayQueue();
        q3.displayQueue();
        q4.displayQueue();
        q5.displayQueue();
        System.out.println("------------------------------------------------------------------");
    }

}
*/
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int total = sc.nextInt();
        System.out.println("Enter no of Queues");
        int n = sc.nextInt();
        int size = total/n;
        int[] array = new int[n*size];// can also put int[total]

        Queue[] q = new Queue[n];
        int t1=0, t2=-1;
        for (int i=0; i<n; i++){
            q[i] = new Queue(size, t1, t2, array);
            t1+=size;
            t2+=size;
        }

        int x = 1;
        while(x!=0){
            System.out.println("Enter your choice of action.\n1.Enqueue\n2.Dequeue\n0.Exit");
            x = sc.nextInt();
            switch(x){
                case 1: {
                    System.out.println("Enter Queue number between 1 to "+n);
                    int i = sc.nextInt();
                    System.out.println("Enter data to be Enqueued");
                    int data = sc.nextInt();
                    q[i-1].enqueue(data);
                    display(q,n);
                    break;
                }
                case 2: {
                    System.out.println("Enter Queue number between 1 to "+n);
                    int i = sc.nextInt();
                    q[i-1].dequeue();
                    display(q,n);
                    break;
                }
                case 0: {
                    System.out.println("Thank You!");
                    x = 0;
                    break;
                }

            }// end switch

        }// end while loop
    }//end main method

    public static void display(Queue [] q,int n) {
        System.out.println("--------------------------------------------");
        for (int i=0; i< n; i++)
            q[i].displayQueue();
        System.out.println("--------------------------------------------");
    }

}//end Main class
