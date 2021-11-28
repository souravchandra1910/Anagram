// 1. You are given two strings s1, s2, and a number K.
// 2. You have to find if two strings are K-anagrams of each other or not.
// 3. Two strings are called K-anagrams if 
//    -> Both s1 and s2 have the same number of characters.
//    -> After changing K characters in any string, s1 and s2 become anagram of each other. 

// Note -> Both s1 ad s2 consist of lowercase English letters only.

import java.util.*;

public class Main2 {
	public static boolean areKAnagrams(String str1, String str2, int k) {
	   if(str1.length()!=str2.length()){
	       return false;
	   }
	   HashMap<Character,Integer>hm=new HashMap<>();
	   for(int i=0;i<str1.length();i++){
	       char ch=str1.charAt(i);
	       hm.put(ch,hm.getOrDefault(ch,0)+1);
	   }
	   
	    for(int i=0;i<str1.length();i++){
	       char ch=str2.charAt(i);
	       if(hm.getOrDefault(ch,0)>0){
	           hm.put(ch,hm.get(ch)-1);
	       }
	   }
	   
	   int count=0;
	   for(char key:hm.keySet()){
	       count+=hm.get(key);
	   }
	   if(count<=k){
	       return true;
	   }
	  else
		return false;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		int k = s.nextInt();
		System.out.println(areKAnagrams(str1, str2, k));

	}

}
