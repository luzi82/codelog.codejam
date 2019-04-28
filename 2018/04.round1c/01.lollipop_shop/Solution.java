import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = nextInt(in);
        for(int t=0;t<T;++t){
            int N = nextInt(in);
            int F = N;
            int[] fToWantCntAry = new int[F];
            boolean[] fToSoldAry = new boolean[F];
            for(int n=0;n<N;++n){
                int D = nextInt(in);
                int[] flavourAry = new int[D];
                for(int d=0;d<D;++d){
                    flavourAry[d] = nextInt(in);
                }
                
                // fill fToWantCntAry
                for(int f:flavourAry){
                    fToWantCntAry[f]++;
                }
                
                // find less wanted
                int minWantCnt = Integer.MAX_VALUE;
                int minWantF = -1;
                for(int f:flavourAry){
                    if(fToSoldAry[f])continue;
                    int wantCnt = fToWantCntAry[f];
                    if(wantCnt<minWantCnt){
                        minWantCnt = wantCnt;
                        minWantF = f;
                    }
                }
                
                // no f found
                if(minWantF==-1){
                    System.out.println(-1);
                }else{
                    fToSoldAry[minWantF] = true;
                    System.out.println(minWantF);
                }
            }
        }
    }
    
    public static int nextInt(Scanner in){
        int ret = in.nextInt();
        if(ret==-1)System.exit(0);
        return ret;
    }
    
}
