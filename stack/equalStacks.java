import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int maxStackIndex(int[] a){
        
        int max3 = Math.max(Math.max(a[0], a[1]), a[2]);
        
        if(a[0] == max3)
            return 0;
        else if(a[1] == max3)
            return 1;
        else
            return 2;
        // 2 same max = ? 2 2 1 case is not significant
    }
    
    public static int noOfSameHeightStacks(int[] heightArray){
        if(heightArray[0] == heightArray[1] && heightArray[0] == heightArray[2])
            return 3;
        return 0;
    }
    
    public static int equalStacks(Stack<Integer> h1, Stack<Integer> h2, Stack<Integer> h3, int[] heightArray) {
    // popForEquality()
        int noOfEqualHeightStacks = noOfSameHeightStacks(heightArray);
        int ans;
        //3 StacksHaveSameHeight
        if(noOfEqualHeightStacks == 3)
            return heightArray[0];
        
        else
        {
            // System.out.println("StacksHaveSameHeight ");
            // System.out.println("In equal stack method" + "heightArray[" +idx + "] = " +heightArray[idx]);
            // System.out.println(h1.peek() + " " + heightArray[2]);
            int idx = maxStackIndex(heightArray);
           
            if(idx == 0)
                heightArray[idx] -= h1.pop();
            else if(idx == 1)
                heightArray[idx] -= h2.pop();
            else
                heightArray[idx] -= h3.pop();
           
            
            ans = equalStacks(h1, h2, h3, heightArray);
        }
        
        return ans; 
    }

}

public class Solution {
 
    public static void main(String[] args) {
         int size1, size2, size3;
         int[] heightArray = new int[3];
         
         Scanner sc = new Scanner(System.in);
         size1 = sc.nextInt();
         size2 = sc.nextInt();
         size3 = sc.nextInt();
         
         int[] arr1 = new int[size1], arr2 = new int[size2], arr3 = new int[size3];
         Stack<Integer> stk1 = new Stack<>(), stk2 = new Stack<>(), stk3 = new Stack<>();
    
         //input in arrays
        
         int i = 0;// arr1
         while(i < size1){
             arr1[i++] = sc.nextInt();
             heightArray[0] += arr1[i-1]; 
         }
         
         i = 0;//arr2
         while(i < size2){
             arr2[i++] = sc.nextInt();
             heightArray[1] += arr2[i-1]; 
         }
         
         i = 0;//arr3
         while(i < size3){
             arr3[i++] = sc.nextInt();
             heightArray[2] += arr3[i-1]; 
         }
        
        //transfering data to stack
        for(i = size1 - 1; i >= 0; i--)
            stk1.push(arr1[i]);
        
        for(i = size2 - 1; i >= 0; i--)
            stk2.push(arr2[i]);

        for(i = size3 - 1; i >= 0; i--)
            stk3.push(arr3[i]);
 
        Result ans = new Result();
        
        System.out.println(ans.equalStacks(stk1, stk2, stk3, heightArray));
    }
}
//ideas:
// stacks array 
// equalStackfor2(h1,..,idx)

//removed code
// StringBuilder hNo = new StringBuilder();
//             hNo.append("h");
//             hNo.append(Integer.toString(idx));
//             System.out.println("hNo = "+ hNo + " ");

//trivial code
//  public static boolean twoStacksHaveSameHeight(int[] heightArray){
//         return (heightArray[0] == heightArray[1] || heightArray[0] == heightArray[2] || heightArray[1] == heightArray[2]);
//     }
    
