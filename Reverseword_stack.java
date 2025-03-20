
import java.util.Stack;

public class Reverseword_stack{
    public static void main(String[] args)
    {

        String str = "Hello";
        Stack <Character> stack = new Stack<>();

        for (char c : str.toCharArray()){
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while(!stack.isEmpty()){
            reversed.append(stack.pop());
        }

        System.out.println("Reversed word : " + reversed);

    }
}