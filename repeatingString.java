import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
         long countA =0;
        List<Integer> AIndex = new ArrayList<Integer>();
        //check if the string has an A
        int hasAFlag = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'||s.charAt(i)=='A'){
                hasAFlag =1;
                AIndex.add(i);
            }
        }
        if(hasAFlag==1){
            //count number of As
           
            if(AIndex.size()>0){
                long min = n/s.length();
                min = min*AIndex.size();
                long remainder = n%s.length();
                int k = 0;
                countA = min;
                while(AIndex.get(k)<remainder){
                    k++;
                    countA++;
                }
            }
        }
        return countA;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
