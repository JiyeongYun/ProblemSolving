import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1]-b[1]; // 끝나는 게 빠른 기준으로 정렬
            }
        });

        int last = -30001;

        for(int i = 0; i < routes.length; i++){
            if(last < routes[i][0]){
                last = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}
