/**
 * stack
 */
import java.util.*;
import java.util.Arrays;

public class stack {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();
        int[] A = {80, 19, 49, 45, 65, 71, 76, 28, 68, 66};
        int[] B = {80, 19, 49, 45, 65, 71, 76, 28, 68, 66};
        Arrays.sort(B);
        int[] result = new int[A.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        if (st.empty()) {
            st.push(B[0]);
        }
        for (int i = 1; i < B.length; i++) {
            
            if (st.peek()>=B[i]) {
                st.push(B[i]);
            } else {
                while (!st.empty()&&st.peek()<B[i]) {
                    int a = st.pop();
                    // System.out.println(a);
                    // System.out.println(search(a, A));
                    // System.out.println(search(B[i], A));
                    if (search(B[i], A)>search(a, A)) {
                        result[search(a, A)] = search(B[i], A);

                    }
                }
                st.push(B[i]);
            }
        }
        for (int r : result) {
            System.out.println(r);
        }

    }

    public static int search(int a,int[] B) {
        for (int i = 0; i < B.length; i++) {
            if (B[i]==a) {
                return i;
            }
        }
        return -1;
    }
}