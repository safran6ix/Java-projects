
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

        boolean ea = !st.empty();
        System.out.println(ea);

        //SEARCH
        //find the position of 2
        System.out.println(st);
        int po2 = st.search(2);
        System.out.println("Position of two is : " + po2);

        //find the position of 4
        System.out.println(st);
        int po4 = st.search(4);
        System.out.println("Position of four is : " + po4);
    }
}