// 1. You are given two integer arrays(A and B), where B is an anagram of A.
// 2. B is an anagram of A means B is made by randomizing the order of the elements in A.
// 3. For every element in A, you have to print the index of that element in B.

// Note -> Both arrays(A and B) are of the same length

import java.util.*;

public class Main3 {
    public static class pair{
        int idx=0;
        ArrayList<Integer>al=new ArrayList<>();
    }
	public static int[] anagramMappings(int[] arr1, int[] arr2) {
	  HashMap<Integer,pair>hm=new HashMap<>();
	  for(int i=0;i<arr2.length;i++){
	      if(hm.containsKey(arr2[i])){
	          pair p=hm.get(arr2[i]);
	          p.al.add(i);
	      }
	      else {
	       pair p=new pair();
	       p.al.add(i);
	      hm.put(arr2[i],p);
	      }
	  }
	  
	  int []ans=new int[arr1.length];
	  for(int i=0;i<arr1.length;i++){
	      pair p=hm.get(arr1[i]);
	      ans[i]=p.al.get(p.idx);
	      p.idx++;
	  }

		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}

}

