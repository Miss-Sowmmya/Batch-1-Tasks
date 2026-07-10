import java.util.Scanner;

class Node
{
   int data;
   Node next;
   Node(int data)
   {
       this.data =data;
   }
}
public class Singly_linked_list {
    public static Node head = null;
    static void main() {
        Scanner input = new Scanner(System.in);
        int val;
        while(true)
        {
            val = input.nextInt();
            if(val==-1)
                break;
            end_insertion(val);
        }
        display();

       // begin_delete();
       // end_delete();
      //  position_delete(5);
      //  display();
        int key=12;
        System.out.println(linear_search(key));

        delete_key(40);
    }
    public static void begin_insertion(int ele)
    {
        Node newnode = new Node(ele);
        if(head==null)
        {
            head=newnode;
        }
        else {
            newnode.next =head;
            head = newnode;
        }
    }
    public static void display()
    {
        if(head==null)
            System.out.println("list is empty");
        else {
            Node temp = head;
            while(temp!=null)
            {
                System.out.print(temp.data+" ");
                temp =temp.next;
            }
        }
    }
    public static void end_insertion(int ele)
    {
        Node newnode = new Node(ele);
        if(head==null)
        {
            head=newnode;
        }
        else {
            Node temp = head;
            while(temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = newnode;
        }
    }
    public static void position_insertion(int pos,int ele)
    {
        Node newnode =new Node(ele);
        if(head==null)
        {
            if(pos==1)
            {
                newnode.next =head;
                head = newnode;
            }
            else System.out.println("position not available");
        }
        else {

            if(pos==1)
            {
                newnode.next =head;
                head = newnode;
            }
            else {
                Node temp = head;
                int i;
                for(i=1;i<=pos-2;i+=1)
                {
                    if(temp.next==null)
                        break;
                    temp = temp.next;
                }
                if(i<=pos-2)
                    System.out.println("position not availbale");
                else
                {
                    newnode.next=temp.next;
                    temp.next = newnode;
                }
            }
        }
    }
    public static void begin_delete()
    {
        if(head==null)
            System.out.println("list is empty");
        else
        {
            head=head.next;
        }
    }
    public static void end_delete()
    {
        if(head==null)
            System.out.println("list is empty");
        else
        {
            if(head.next==null)
                head=null;
            else {
                Node temp = head;
                while(temp.next.next!=null)
                  temp=temp.next;

                temp.next =null;
            }
        }
    }
    public static void position_delete(int pos)
    {
        if(head== null)
            System.out.println("list is empty");
        else
        {
            if(head.next==null)
            {
                if(pos==1)
                {
                    head=null;
                }
                else System.out.println("invalid position");
            }
            else {
               if(pos==1)
               {
                   head=head.next;
               }
               else {
                   Node temp =head;
                   int itr;
                   for(itr=1;itr<=pos-2;itr+=1)
                   {
                       if(temp.next==null)
                           break;
                       temp = temp.next;
                   }
                   if(itr<=pos-2)
                       System.out.println("invalid position");
                   else
                   {
                       try
                       {
                           temp.next = temp.next.next;
                       }catch (Exception e)
                       {
                           System.out.println("Invalid position");
                       }
                   }

               }
            }
        }
    }

    public static boolean linear_search(int key)
    {
        if(head==null)
            return false;
        else if(head.next==null)
        {
            if(head.data==key)
                return true;
        }

        Node temp =head;
        while(temp!=null)
        {
            if(temp.data==key)
                return true;

            temp = temp.next;
        }
        return false;
    }

    public static void delete_key(int key)
    {
        if(head==null)
            return;

    }


}
