
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
}

public class Defstack{
    public static void main(String[] args)
    {

        MinStack minStack = new MinStack();


    }
}