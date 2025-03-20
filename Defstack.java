
import java.util.Stack;

class MinStack{
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x){
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()){
           minStack.push(x);
        }
    }

    public void pop(){
        if(!stack.isEmpty()){
            int popped = stack.pop();
            if(popped == minStack.peek()){
                minStack.pop();
            }
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }


}

public class Defstack{
    public static void main(String[] args)
    {

        MinStack minStack = new MinStack();

        minStack.push(6);
        minStack.push(5);
        minStack.push(4);

        System.out.println(minStack.getMin());
        minStack.pop();

        System.out.println(minStack.getMin());
        minStack.pop();

        System.out.println(minStack.getMin());

    }
}