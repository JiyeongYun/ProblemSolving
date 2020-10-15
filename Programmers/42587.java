import java.util.*;

class Print{
  int location;
  int priority;

  Print(int location, int priority){
    this.location = location;
    this.priority = priority;
  }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int max, max_index = priorities.length-1, answer = 0;

        Queue q = new LinkedList();
        for(int i = 0; i < priorities.length; i++){
            q.offer(new Print(i, priorities[i]));
        }

        Arrays.sort(priorities);
        max = priorities[max_index];

        while(!q.isEmpty()){
            Print print = (Print)(q.poll());

            if(print.priority < priorities[max_index]){
                q.offer(print);
            }else{
                max_index--;
                max = priorities[max_index];
                answer++;
                if(print.location == location){
                    break;
                }
            }
        }

        return answer;
    }
}
