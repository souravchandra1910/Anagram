// 1. You are given two strings s1 and s2.
// 2. You have to find the count of s2's anagrams that are present in s1.
// 3. Also, you have to print the start indices of such anagrams in s1.

// Note -> Both s1 ad s2 consist of lowercase English letters only.

import java.util.*;
public class Solution {
    public static boolean check(HashMap<Character,Integer>hm1,HashMap<Character,Integer>hm2){
        if(hm1.equals(hm2)){
            return true;
        }
        return false;
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer>al=new ArrayList<>();
        if(s.length()==0 || p.length()==0 || s.length()<p.length()){
            return al;
        }
        HashMap<Character,Integer>hm1=new HashMap<>();
        HashMap<Character,Integer>hm2=new HashMap<>();
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            hm1.put(ch,hm1.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<p.length();i++){
          char ch=s.charAt(i);
           hm2.put(ch,hm2.getOrDefault(ch,0)+1);
        }
         int j=0;
        
        for(int i=p.length();i<s.length();i++){
            if(check(hm1,hm2)==true){
                al.add(j);
            }
            char ch=s.charAt(i);
            hm2.put(ch,hm2.getOrDefault(ch,0)+1);
            
            
            char ch1=s.charAt(j);
            int freq=hm2.get(ch1);
            if(freq==1){
                hm2.remove(ch1);
            }
            else{
                hm2.put(ch1,freq-1);
            }
            j++;
        }
         if(check(hm1,hm2)==true){
                al.add(j);
            }
        return al;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(findAnagrams(s1,s2));
    }
   
}
