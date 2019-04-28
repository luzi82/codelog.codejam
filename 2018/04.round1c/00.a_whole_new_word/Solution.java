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
            int L = in.nextInt();
            String[] txtAry = new String[N];
            for(int n=0;n<N;++n){
                txtAry[n] = in.next();
            }
            
            String ret = process(N, L, txtAry);
            System.out.println(String.format("Case #%d: %s", t+1, ret));
        }
    }
    
    public static String process(int N, int L, String[] txtAry){
        HashSet<Character>[] charSetAry = new HashSet[L];
        for(int l=0;l<L;++l){
            charSetAry[l] = new HashSet<Character>();
            for(String txt:txtAry){
                char c = txt.charAt(l);
                charSetAry[l].add(c);
            }
        }
        
        // check contains all combo
        int totalCombination = 1;
        for(int l=0;l<L;++l){
            totalCombination *= charSetAry[l].size();
            if(totalCombination>txtAry.length)break;
        }
        if(totalCombination==txtAry.length){return "-";}
        
        // sort txtAry
        Arrays.sort(txtAry);
        
        int searchStart = 0, searchEnd = txtAry.length;
        String ret = "";
        for(int l=0;l<L;++l){
            if(searchStart<searchEnd){
                HashMap<Character,Integer> charToCountMap = new HashMap<>();
                for(Character c:charSetAry[l]){charToCountMap.put(c,0);}
                for(int i=searchStart;i<searchEnd;++i){
                    char c = txtAry[i].charAt(l);
                    charToCountMap.put(c,charToCountMap.get(c)+1);
                }
                int minCount = Integer.MAX_VALUE;
                char minChar = '0';
                for(Map.Entry<Character,Integer> charToCountEntry: charToCountMap.entrySet()){
                    char c = charToCountEntry.getKey();
                    int count = charToCountEntry.getValue();
                    if(count<minCount){
                        minCount = count;
                        minChar = c;
                    }
                }
                String minString = ret+new String(new char[]{minChar});
                String maxString = ret+new String(new char[]{(char)(minChar+1)});
                
                int newSearchStart = Arrays.binarySearch(txtAry, searchStart, searchEnd, minString);
                int newSearchEnd   = Arrays.binarySearch(txtAry, searchStart, searchEnd, maxString);
                if(newSearchStart<0){
                    newSearchStart = -newSearchStart-1;
                }
                if(newSearchEnd<0){
                    newSearchEnd = -newSearchEnd-1;
                    while(true){
                        if(newSearchEnd>=txtAry.length)break;
                        if(!txtAry[newSearchEnd].startsWith(minString))break;
                        ++newSearchEnd;
                    }
                }
                searchStart = newSearchStart;
                searchEnd   = newSearchEnd;
                
                ret = minString;
            }else{
                char c = charSetAry[l].iterator().next();
                ret += new String(new char[]{c});
            }
        }
        
        return ret;
    }
    
}
