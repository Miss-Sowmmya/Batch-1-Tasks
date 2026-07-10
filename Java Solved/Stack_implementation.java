import java.util.Scanner;

class stack_Node
{
    int data;
    stack_Node next;
    stack_Node(int data)
    {
        this.data = data;
    }
}
public class Stack_implementation {
    public static stack_Node top =null;
    static void main() {
        Scanner input = new Scanner(System.in);
        System.out.println("1.push() 2.pop() 3.peek() 4.display() 5.size() 6.empty() -1 for exit");
        int choice;

        while(true)
        {
            choice = input.nextInt();
            if(choice==-1)
                break;
            switch(choice)
            {
                case 1:{
                    int ele = input.nextInt();
                    push(ele);
                }break;

                case 2:pop();break;
                case 3:{
                    System.out.println("peek element is "+peek());
                }break;
                case 4:display();break;

            }
        }


    }
    public static void push(int val)
    {
       stack_Node newnode = new stack_Node(val);
       if(top==null)
           top = newnode;
       else
       {
           newnode.next = top;
           top = newnode;
       }
    }
    public static void display()
    {
        if(top==null)
            System.out.println("Empty");
        else
        {
            stack_Node temp = top;
            while(temp!=null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
    public static void pop()
    {
        if(top==null)
            System.out.println("underflow");
        else {
            top = top.next;
        }
    }

    public static int peek()
    {
        if(top==null)
            return -1;
        return top.data;
    }
}
