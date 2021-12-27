public class main5 {
    public boolean isAnagram(String s1, String s2) {
        if(s1.length()!=s2.length()){
           return false;
         }
        int []map=new int [26];
        for(int i=0;i<s1.length();i++){
         char ch=s1.charAt(i);
         map[ch-'a']++;// map[0]++// map[0]=map[0]+1
       }                         // map[0]=0+1;
        
        for(int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);
            map[ch-'a']--;
        }
        
        for(int i:map){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
