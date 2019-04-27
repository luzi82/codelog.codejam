import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for(int t=0;t<T;++t){
            int A = in.nextInt();
            int B = in.nextInt();
            int N = in.nextInt();
            
            int start = A+1;
            int end = B+1;
            while(true){
                int mid = (start+end-1)/2;
                System.out.println(Integer.toString(mid));
                String result = in.next();
                if(result.equals("CORRECT"))break;
                if(result.equals("WRONG_ANSWER"))return;
                if(result.equals("TOO_SMALL"))start = mid+1;
                if(result.equals("TOO_BIG"))end = mid;
            }
        }
    }
    
}
