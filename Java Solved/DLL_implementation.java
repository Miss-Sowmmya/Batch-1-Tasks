import java.util.Scanner;
import java.util.Stack;

class Node1
{
    int data;
    Node1 prev;
    Node1 next;
    Node1(int data)
    {
        this.data = data;
    }
}
public class DLL_implementation {
    public static Node1 head = null;
    static void main() {
        Scanner input = new Scanner(System.in);
        int ele;
        while(true)
        {
            ele = input.nextInt();
            if(ele==-1)
                break;
            insertion(ele); //10 20
        }
        display();
       // backward_display();
        deletion(4);

        backward_display();
        Stack<Character> stack = new Stack<>();


    }
    public static void insertion(int val)//end
    {
        Node1 newnode = new Node1(val);
        if(head==null)
        {
           head = newnode;
        }
        else {
        Node1 temp = head;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        temp.next=newnode;
        newnode.prev = temp;
        }

    }
    public static void deletion(int pos) //
    {
        if(head==null)
            return;
        if(head.next==null)
        {
            if(pos==1)
                head = null;
            else System.out.println("invalid");

        }
        else {
            if(pos==1)
            {
               head = head.next;
               head.prev = null;
            }
            else {
                Node1 temp = head;
                int itr;
                for(itr=1;itr<=pos-1;itr+=1){
                    if(temp.next==null)
                        break;
                    temp =temp.next;
                }
                if(itr<=pos-1)
                    System.out.println("invalid");
                else
                {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }


            }
        }
    }
    public static void display()
    {
        if(head==null)
            return;

        Node1 temp = head;

        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

    }
    public static void backward_display()
    {
        if(head==null)
            return;

        //to find the last node

        Node1 tail = head;
        while(tail.next!=null)
            tail =tail.next;

        while(tail!=null)
        {
            System.out.print(tail.data+" ");
            tail = tail.prev;
        }
    }
}
