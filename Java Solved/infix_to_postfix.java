import java.util.Stack;

public interface infix_to_postfix {
    static void main() {
        Stack<Character> stack = new Stack<>();
        String exp = "A*B+(C/D)%F-G";
        StringBuilder result = new StringBuilder();
        int itr;
        for(itr=0;itr<exp.length();itr+=1)
        {
            char ch = exp.charAt(itr);
            if(ch>='A' && ch<='Z')
                result.append(ch);
            else if(ch=='(')
                stack.push(ch);
            else if(ch==')')
            {
                while(!stack.isEmpty() && stack.peek()!='(')
                    result.append(stack.pop());

                stack.pop();
            }
            else {
                while(!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
                {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while(!stack.isEmpty())
            result.append(stack.pop());

        System.out.println(result);

    }
    public static int precedence(char ch)
    {
        if(ch=='*' || ch=='/' || ch=='%')
            return 2;
        else if(ch=='+' || ch=='-')
            return 1;
        return 0;
    }

}