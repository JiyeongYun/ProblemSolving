import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int min = 0;

        PriorityQueue<Integer> scovilleList = new PriorityQueue<Integer>();
        for(int i = 0; i < scoville.length; i++){
            scovilleList.offer(scoville[i]);
        }

        while (!scovilleList.isEmpty()) {
            min = scovilleList.peek();
            if(min >= K) return answer;
            else if(scovilleList.size() == 1) return -1;

            int num1 = scovilleList.poll();
            int num2 = scovilleList.poll();
            int num = num1 + num2 * 2;

            scovilleList.offer(num);
            answer++;

        }

        return -1;
    }
}
