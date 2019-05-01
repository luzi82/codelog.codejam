import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for(int t=0;t<T;++t){
            long N = in.nextLong();
            long K = in.nextLong();
            
            TreeMap<Long,Long> widthToCountMap = new TreeMap<>();
            widthToCountMap.put(N,1L);
            
            long lastWidth = -1;
            while(true){
                long maxWidth = widthToCountMap.lastKey();
                long count = widthToCountMap.get(maxWidth);
                //System.err.println(String.format("%d %d",maxWidth,count));
                if(maxWidth==0)throw new Error("asdf");
                K -= count;
                if(K<=0){
                    lastWidth = maxWidth;
                    break;
                }
                widthToCountMap.remove(maxWidth);
                add(maxWidth/2,count,widthToCountMap);
                add((maxWidth-1)/2,count,widthToCountMap);
            }
            
            System.out.println(String.format("Case #%d: %d %d",t+1,lastWidth/2,(lastWidth-1)/2));
        }
    }

    public static void add(long k,long v,TreeMap<Long,Long> map){
        long old = get(k,map);
        old+=v;
        map.put(k,old);
    }
    
    public static long get(long k,TreeMap<Long,Long> map){
        if(!map.containsKey(k)){
            return 0;
        }
        return map.get(k);
    }
    
}
