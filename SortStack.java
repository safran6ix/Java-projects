import java.util.Scanner;
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

        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter the numbers : ");
        int num1 = scan.nextInt();
        stack.push(num1);
        int num2 = scan.nextInt();
        stack.push(num2);
        int num3 = scan.nextInt();
        stack.push(num3);

        System.out.println("Your shortage numbers");
        sort(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
        System.out.print("Program Ended...");
    }
}
