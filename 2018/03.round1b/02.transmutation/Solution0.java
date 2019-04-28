import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;
import java.io.*;

// TLE

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for(int t=0;t<T;++t){
            int M = in.nextInt();
            int[] r0Ary = new int[M];
            int[] r1Ary = new int[M];
            int[] gAry  = new int[M];
            for(int m=0;m<M;++m){
                r0Ary[m] = in.nextInt()-1; // zero idx
                r1Ary[m] = in.nextInt()-1;
            }
            for(int m=0;m<M;++m){
                gAry[m] = in.nextInt();
            }
            
            boolean[][] fromToAryAry = new boolean[M][M];
            
            long ret = 0;
            long[] requirementAry = new long[M];
            requirementAry[0] = 1;
            long requirementTotal = 1;
            long gTotal = 0;
            for(int m=0;m<M;++m){
                gTotal += gAry[m];
            }

            while(true){
                // reduce g
                long retPlus = Integer.MAX_VALUE;
                for(int m=0;m<M;++m){
                    if(requirementAry[m]==0)continue;
                    retPlus = Math.min(retPlus,gAry[m]/requirementAry[m]);
                }
                ret += retPlus;
                for(int m=0;m<M;++m){
                    long used = requirementAry[m] * retPlus;
                    gAry[m] -= used;
                    gTotal -= used;
                }
                
                // bye for gTotal < requirementTotal
                if(gTotal < requirementTotal)break;
                
                // find m to break
                int lessM = -1; // 
                for(int m=0;m<M;++m){
                    if(gAry[m]<requirementAry[m]){
                        lessM = m;
                        break;
                    }
                }
                
                // check loop
                fromToAryAry[r0Ary[lessM]][lessM] = true;
                fromToAryAry[r1Ary[lessM]][lessM] = true;
                if(findLoop(fromToAryAry)) break;
                
                // break m
                long breakCnt = requirementAry[lessM] - gAry[lessM];
                requirementAry[lessM] -= breakCnt;
                requirementAry[r0Ary[lessM]] += breakCnt;
                requirementAry[r1Ary[lessM]] += breakCnt;
                requirementTotal += breakCnt;

                // bye for gTotal < requirementTotal
                if(gTotal < requirementTotal)break;
            }
            
            System.out.println(String.format("Case #%d: %d",t+1,ret));
        }
    }
    
    public static boolean findLoop(boolean[][] fromToAryAry){
        fillFromToAryAry(fromToAryAry);
        int M = fromToAryAry.length;
        for(int m=0;m<M;++m){
            if(fromToAryAry[m][m])return true;
        }
        return false;
    }
    
    public static void fillFromToAryAry(boolean[][] fromToAryAry){
        int M = fromToAryAry.length;
        while(true){
            boolean fillDone = false;
            for(int i=0;i<M;++i)for(int j=0;j<M;++j){
                if(fromToAryAry[i][j])continue;
                for(int k=0;k<M;++k){
                    boolean fill = fromToAryAry[i][k]&&fromToAryAry[k][j];
                    fromToAryAry[i][j] = fill;
                    if(fill)break;
                }
                fillDone = fillDone || fromToAryAry[i][j];
            }
            if(!fillDone)break;
        }
    }
    
}
