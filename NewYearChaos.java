import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int bribes =0 ;
        

       int flag = 0;
       for(int i=0;i<q.length;i++){
           int key = q[i];
           int swaps = findBigger(key,i+1,q.length,q);
           if(swaps<=2){
               bribes+=swaps;
           }
           else{
               flag=1;
           }
       }
        if(flag==1){
            System.out.println("Too chaotic");
        }
        else{
            System.out.println(bribes);
        }
    }
    static int findBigger(int key,int start,int n,int[] q){
        int count=0;
        for(int i =start;i<n;i++){
            if(q[i]<key){
                count++;
                if(count==3){
                    return count;
                }
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
