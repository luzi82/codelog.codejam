import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for(int t=0;t<T;++t){
            double D = (double)in.nextInt();
            int N = in.nextInt();
            double[] KAry = new double[N];
            double[] SAry = new double[N];
            for(int n=0;n<N;++n){
                KAry[n] = (double)in.nextInt();
                SAry[n] = (double)in.nextInt();
            }
            
            double maxTime = 0;
            for(int n=0;n<N;++n){
                maxTime = Math.max(maxTime,(D-KAry[n])/SAry[n]);
            }
            
            double ans = D/maxTime;
            
            System.out.println(String.format("Case #%d: %.06f",t+1,ans));
        }
    }
    
}
