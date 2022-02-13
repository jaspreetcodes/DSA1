import java.io.*;
import java.util.*;

public class Main {

    static String[] keypadAlphabets = new String[]{".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String keypadNo = new String();
        keypadNo = sc.next();

        ArrayList<String> ans = kpc(keypadNo);
        System.out.println(ans);
    }

    public static ArrayList<String> kpc(String keypadNo) {
        //base case
        if(keypadNo.isEmpty())
        {         
            ArrayList<String> baseAl = new ArrayList<>();
            baseAl.add("");
            return baseAl;            
        }
        
        //faith
        ArrayList<String> prevKeyComb = new ArrayList<>();
        prevKeyComb = kpc(keypadNo.substring(1));
        ArrayList<String> newKeyComb = new ArrayList<>();

        //expectation to faith
        Integer i = Integer.parseInt(Character.toString(keypadNo.charAt(0)));
        
        for(int j = 0; j < keypadAlphabets[i].length(); j++)
        {
            for(String elem : prevKeyComb)
                newKeyComb.add(keypadAlphabets[i].charAt(j) + elem);
        }

        return newKeyComb;
    }

}
