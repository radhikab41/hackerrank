import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
    int[] removed = new int[s.length()];
    int[] ab = new int[s.length()];
        for(int i=0;i<s.length();i++){
            removed[i]=0;
            if(s.charAt(i)=='A'){
                ab[i]=1;
            }
            else{
                ab[i]=0;
            }
        }
        
        for(int i=0;i<s.length()-1;i++){
            if(ab[i]==ab[i+1]){
                removed[i]=1;
            }
        }
        int sum=0;
        for(int i=0;i<removed.length;i++){
            sum+=removed[i];
        }
    return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
