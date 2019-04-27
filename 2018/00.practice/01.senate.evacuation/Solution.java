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
            int[] PAry = new int[N];
            for(int n=0;n<N;++n){
                PAry[n] = in.nextInt();
            }
            
            int maxP = Integer.MIN_VALUE;
            int totalP = 0;
            HashMap<Integer,LinkedList<Integer>> pToNListMap = new HashMap<>();
            for(int n=0;n<N;++n){
                int p = PAry[n];
                put(p,n, pToNListMap);
                maxP = Math.max(maxP, p);
                totalP += p;
            }
            
            System.out.print(String.format("Case #%d:",t+1));
            while(maxP>0){
                int n0 = pull(maxP, pToNListMap);
                --totalP;
                if(pToNListMap.get(maxP).size()<=0)--maxP;
                if(totalP%2==0){
                    System.out.print(" "+(char)('A'+n0));
                    continue;
                }
                int n1 = pull(maxP, pToNListMap);
                --totalP;
                if(pToNListMap.get(maxP).size()<=0)--maxP;
                System.out.print(" "+(char)('A'+n0)+(char)('A'+n1));
            }
            System.out.println();
        }
    }
    
    public static void put(int p, int n, HashMap<Integer,LinkedList<Integer>> pToNListMap){
        if(!pToNListMap.containsKey(p)){
            pToNListMap.put(p,new LinkedList<Integer>());
        }
        LinkedList<Integer> nList = pToNListMap.get(p);
        nList.addLast(n);
    }
    
    public static int pull(int p, HashMap<Integer,LinkedList<Integer>> pToNListMap){
        int n=pToNListMap.get(p).removeLast();
        --p;
        if(p>0){
            put(p,n,pToNListMap);
        }
        return n;
    }
    
}
