import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for(int t=0;t<T;++t){
            int N = in.nextInt();
            int WAry[] = new int[N];
            for(int n=0;n<N;++n){
                WAry[n] = in.nextInt();
            }
            
            long[] heightToWeightAry = new long[N+1];
            heightToWeightAry[0] = 0;
            int heightToWeightCount = 1;
            
            for(int n=0;n<N;++n){
                long W = WAry[n];
                long P = W*6;
                
                if(P>=heightToWeightAry[heightToWeightCount-1]){
                    heightToWeightAry[heightToWeightCount] = heightToWeightAry[heightToWeightCount-1]+W;
                    ++heightToWeightCount;
                }
                for(int h=heightToWeightCount-2;h>=0;--h){
                    if(P>=heightToWeightAry[h]){
                        long w = heightToWeightAry[h]+W;
                        heightToWeightAry[h+1] = Math.min(w,heightToWeightAry[h+1]);
                    }
                }
            }
            
            System.out.println(String.format("Case #%d: %d",t+1,heightToWeightCount-1));
        }
    }
    
}
