import java.util.*;
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
    }
}
public class Binary_tree_implementation
{
    public static Node root = null;
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        while (true)
        {
            int ele = input.nextInt();
            if (ele == -1)
                break;

            insertion(ele);
        }
        System.out.println("Inorder");
        inorder(root);
        System.out.println("\nPreorder");
        preorder(root);
        System.out.println("\nPostorder");
        postorder(root);
        System.out.println("\nLevel order");
        level_order();
        deletion(20);
        System.out.println("\nAfter Deletion");
        level_order();
        input.close();
    }
    public static Node create_node(int val)
    {
        return new Node(val);
    }
    public static void insertion(int val)
    {
        if (root == null)
        {
            root = create_node(val);
            return;
        }
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty())
        {
            Node cur = que.poll();
            if (cur.left == null)
            {
                cur.left = create_node(val);
                return;
            }
            else
                que.offer(cur.left);

            if (cur.right == null)
            {
                cur.right = create_node(val);
                return;
            }
            else
                que.offer(cur.right);
        }
    }
    public static void inorder(Node root)
    {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void preorder(Node root)
    {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void postorder(Node root)
    {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    public static void level_order()
    {
        if (root == null)
            return;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty())
        {
            Node cur = que.poll();
            System.out.print(cur.data + " ");
            if (cur.left != null)
                que.offer(cur.left);
            if (cur.right != null)
                que.offer(cur.right);
        }
    }
    public static void deletion(int key)
    {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
        {
            if (root.data == key)
                root = null;
            return;
        }
        Node target = null;
        Node last = null;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty())
        {
            last = que.poll();
            if (last.data == key)
                target = last;
            if (last.left != null)
                que.offer(last.left);

            if (last.right != null)
                que.offer(last.right);
        }
        if (target != null)
        {
            target.data = last.data;
            delete_last_node(last);
        }
    }
    public static void delete_last_node(Node last)
    {
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty())
        {
            Node cur = que.poll();
            if (cur.left != null)
            {
                if (cur.left == last)
                {
                    cur.left = null;
                    return;
                }
                que.offer(cur.left);
            }
            if (cur.right != null)
            {
                if (cur.right == last)
                {
                    cur.right = null;
                    return;
                }
                que.offer(cur.right);
            }
        }
    }
}