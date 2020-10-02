import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0, right = people.length-1;

        ArrayList<Integer> peopleList = new ArrayList<>();
        for(int i = 0; i < people.length; i++) peopleList.add(people[i]);
        Collections.sort(peopleList);

        while(left < right){
            if(peopleList.get(left) + peopleList.get(right) > limit){
                right--;
                answer++;
            } else {
                left++;
                right--;
                answer++;
            }
        }

        if(left == right ) answer++;
        return answer;
    }
}
