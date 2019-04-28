import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;
import java.io.*;

class Check {

    public static void main(String[] args) {
        // check the max height possiable
        int height = 1;
        long weight = 1;
        long BIG = 1_000_000_000;
        while(true){
            long next = (weight+5)/6;
            if(next>BIG)break;
            weight+=next;
            ++height;
            System.out.println(String.format("%d %d %d",height,weight,next));
        }
    }
    
}
