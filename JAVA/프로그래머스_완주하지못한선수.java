import java.util.Arrays;

public class 프로그래머스_완주하지못한선수 {

	   public String solution(String[] participant, String[] completion) {
	        Arrays.sort(participant);
	        Arrays.sort(completion);
	        
	        int index=0;
	        for(String name:completion){
	            if(!name.equals(participant[index]))
	                return participant[index];
	            index+=1;
	        }
	        return participant[participant.length-1];
	    }
}
//import java.util.HashMap;
/*class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hash_map=new HashMap<>();
        for(String name : participant){
            hash_map.put(name,hash_map.getOrDefault(name,0)+1);
        }
        for(String name : completion){
            hash_map.put(name,hash_map.get(name)-1);
        }
        for(String name: hash_map.keySet()){
            if(hash_map.get(name)!=0){
                answer=name;
                break;
            }            
        }
        return answer;
    }
}*/