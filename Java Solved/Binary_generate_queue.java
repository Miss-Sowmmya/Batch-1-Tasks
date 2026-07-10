import java.util.*;
public class Binary_generate_queue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        Queue<String> que = new LinkedList<>();
        que.offer("1");
        for (int i = 0; i < num; i++) {
            String curr = que.poll();
            System.out.print(curr + " ");
            que.offer(curr + "0");
            que.offer(curr + "1");
        }
    }
}