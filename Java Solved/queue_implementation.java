import java.util.Scanner;

class Node3
{
    int data;
    Node3 next;
    Node3(int data)
    {
        this.data= data;
    }
}
public class queue_implementation {
    public static Node3 front=null,rear=null;
    static void main() {
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("1.Enqueue() 2.Dequeue 3.display() -1 for exit");
        while(true)
        {
            choice = input.nextInt();
            if(choice==-1)
                break;
            switch(choice)
            {
                case 1:{
                    int ele = input.nextInt();
                    enqueue(ele);
                }break;
                case 2:dequeue();break;
                case 3:display();
            }
        }
    }

    public static void enqueue(int val) //end insert
    {
        Node3 newnode = new Node3(val);
        if(front==null)
        {
          front = newnode;
          rear = newnode;
        }
        else
        {
            rear.next = newnode;
            rear = newnode;
        }
    }
    public static void display()
    {
        if(front==null)
        {
            System.out.println("empty");
            return;
        }


        Node3 temp = front;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp =temp.next;
        }
    }
    public static void dequeue()
    {
        if(front==null){
            return;
        }


        if(front.next==null)
        {
            front=null;
            rear =null;
        }
        else
        {
            front = front.next;
        }

    }
}
