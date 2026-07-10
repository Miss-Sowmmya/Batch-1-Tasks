import java.util.Scanner;

class Node4
{
    int data;
    Node4 next;
    Node4(int data)
    {
        this.data =data;
    }
}
public class Deque_implementation {
    public static Node4 front=null,rear=null;
    static void main() {
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("1.Enqueue_rear() 2.Enqueue_front() 3.dequeue_rear() 4.dequeue_front() 5.display() -1 for exit");

        while(true)
        {
            choice = input.nextInt();
            if(choice==-1)
                break;
            switch(choice)
            {
                case 1 : {
                    int ele = input.nextInt();
                    enqueue_rear(ele);
                }break;
                case 2 : {
                    int ele = input.nextInt();
                    enqueue_front(ele);
                }break;
                case 3:Dequeue_end();break;
                case 4:Dequeue_front();break;
                case 5:display();
            }

        }

    }
    public static void enqueue_rear(int val) //end
    {
        Node4 newnode = new Node4(val);
        if(front==null)
        {
            front=newnode;
            rear = newnode;
        }
        else {
            rear.next = newnode;
            rear = newnode;
        }
    }
    public static void enqueue_front(int val)//begin
    {
        Node4 newnode = new Node4(val);
        if(front==null)
        {
            front=newnode;
            rear = newnode;
        }
        else {
            newnode.next = front;
            front=newnode;
        }
    }
    public static void display()
    {
        if(front==null)
        {
            System.out.println("empty");
            return;
        }

        Node4 temp = front;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp =temp.next;
        }
    }
    public static void Dequeue_end() //end
    {
        if(front==null)
            return;
        if(front==rear)
        {
            front=null;
            rear =null;
        }
        else {
            Node4 temp = front;
            while(temp.next!=rear)
                temp =temp.next;

            temp.next=null;
            rear = temp;
        }
    }
    public static void Dequeue_front()
    {
        if(front==null)
            return;
        if(front==rear)
        {
            front=null;
            rear = null;
        }
        else {
            front=front.next;
        }
    }
}
