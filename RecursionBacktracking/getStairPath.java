//  leetcode dp question - frog jump , jump game , max sum non adjacent, etc.
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            // String keypadNo = new String();
            int n = sc.nextInt();

            ArrayList<String> ans = getStairPaths(n);
            System.out.println(ans);
        }

    public static ArrayList<String> getStairPaths(int n) {  

        //+ve base case
        if(n == 0)
        {         
            ArrayList<String> baseAl = new ArrayList<>();
            baseAl.add("");
            return baseAl;            
        }
        
        //faith
        ArrayList<String> prevStairPathComb1 = new ArrayList<>();
        ArrayList<String> prevStairPathComb2 = new ArrayList<>();
        ArrayList<String> prevStairPathComb3 = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();

        //1 jump
        //Avoiding -ve base case
        if(n - 1 >= 0)
        {
            prevStairPathComb1 = getStairPaths(n - 1);
            for(String str : prevStairPathComb1)
                answer.add("1" + str);
        }

        //2 jumps
        //Avoiding -ve base case
        if(n - 2 >= 0)
        {
            prevStairPathComb2 = getStairPaths(n - 2);
            for(String str : prevStairPathComb2)
                answer.add("2" + str);
        }

        //3 jumps
        //Avoiding -ve base case
        if(n - 3 >= 0)
        {
            prevStairPathComb3 = getStairPaths(n - 3);
            for(String str : prevStairPathComb3)    
                answer.add("3" + str);
        }

        return answer;
    }
}
