import java.util.Scanner;

class Node2
{
    int data;
    Node2 prev;
    Node2 next;
    Node2(int data)
    {
        this.data = data;
    }

}
public class CDLL_implementation {
    public static Node2 head =null;
    static void main() {
        Scanner input = new Scanner(System.in);
        int ele;

        while(true)
        {
            ele = input.nextInt();
            if(ele==-1)
                break;
            insertion(ele);
        }
        display();
    }
    public static void insertion(int val)// end
    {
        Node2 newnode= new Node2(val);
        if(head==null)
        {
            head = newnode;
            head.prev =head;
            head.next= head;
        }
        else {
        Node2 temp =head;
        while(temp.next!=head)
            temp = temp.next;

        newnode.prev = temp;
        newnode.next = head;
        temp.next = newnode;
        head.prev = newnode;

        }
    }
    public static void display()
    {
        if(head==null)
            return;

        Node2 temp = head;
        do
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }while(temp!=head);
    }
}
