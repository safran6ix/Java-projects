import java.util.Stack;

class SortStack {
    public static void sort(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int temp = stack.pop();
        sort(stack);
        insertSorted(stack, temp);
    }

    private static void insertSorted(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || value < stack.peek()) {
            stack.push(value);
            return;
        }

        int temp = stack.pop();
        insertSorted(stack, value);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(70);
        stack.push(200);
        stack.push(300);

        sort(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
        System.out.print("Program Ended...");
    }
}
