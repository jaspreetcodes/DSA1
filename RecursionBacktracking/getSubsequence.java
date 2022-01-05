import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = new String();
        str = sc.next();
        System.out.println(gss(0, str));
    }
    
    public static ArrayList<String> gss(int i, String str) {
    //   System.out.println("al.size()");
       int j;
        if(i >= str.length())
        {
            ArrayList<String> al = new ArrayList<>();
            al.add("");
            // System.out.println(al.size());
            return al;
        }
        
        // ArrayList<String> al = new ArrayList<>();
        // al = gss(i + 1, str);
        ArrayList<String> tempAl = new ArrayList<>();
        tempAl = gss(i + 1, str);//shallow copy , i.e only reference is stored
        
        ArrayList<String> ansAl = new ArrayList<>();
        for(String st : tempAl)
            ansAl.add(st);
        // System.out.println(temp);
        for(String st : tempAl)
        {
            // char ch = str.charAt(i);
            // al.get(j)
            // String ans = new String();
            // ans += ch + al.get(j);
            // ans.concat((String)ch);
            // ans.concat(al.get(j));
            ansAl.add(str.charAt(i) + st);
        }
        return ansAl; 
    }

}
