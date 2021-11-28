import java.util.*;

public class Main {
	
	public static boolean solution(String s1, String s2){
	    if( s1 .length()!=s2.length()){
	        return false;
	    }
	  HashMap<Character,Integer>hm=new HashMap<>();
	  for(int i=0;i<s1.length();i++){
	      char ch=s1.charAt(i);
	      hm.put(ch,hm.getOrDefault(ch,0)+1);
	  }
	  for(int i=0;i<s2.length();i++){
	        char ch=s2.charAt(i);
	      if(hm.containsKey(ch)==false){
	          return false;
	      }
	      else{
	          int freq=hm.get(ch);
	          if(freq==1){
	              hm.remove(ch);
	          }
	          else{
	              hm.put(ch,freq-1);
	          }
	      }
	  }

		return hm.size()==0?true:false;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
