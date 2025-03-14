
 import java.util.*;
public class StackConcept{
    public static void main(String[] args){

        Stack <Integer> st = new Stack<>();

        //PUSH
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);

        //POP
        int r = st.pop();
        System.out.println(r);
        System.out.println(st);

        //PEEK
        int p = st.peek();
        System.out.println(p);
        System.out.println(st);

        //EMPTY
        boolean e = st.empty();
        System.out.println(e);


    }
}