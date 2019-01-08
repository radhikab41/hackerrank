import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        List<Character> openBraces = new ArrayList<Character>();
        List<Character> closeBraces = new ArrayList<Character>();
        openBraces.add('(');
        openBraces.add('{');
        openBraces.add('[');

        closeBraces.add(')');
        closeBraces.add('}');
        closeBraces.add(']');

        Stack<Character> parenthesisStack = new Stack<Character>();
        
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(openBraces.contains(ch)){
                parenthesisStack.push(ch);
            }
            else{
                if(!parenthesisStack.isEmpty()){
                     if(closeBraces.contains(ch)){
                    char top = parenthesisStack.peek();
                    if(top=='(' && ch==')'){
                        parenthesisStack.pop();
                    }
                    else if(top=='{' && ch=='}'){
                        parenthesisStack.pop();
                    }
                    else if(top=='[' && ch==']'){
                        parenthesisStack.pop();
                    }
                    else{
                        return "NO";
                    }
                }
                else{
                    return "NO";
                }
               
                }
                else{
                    return "NO";
                }
            }
        }
        if(parenthesisStack.isEmpty()){
            return "YES";
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
