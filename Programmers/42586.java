import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayArr = new int[progresses.length];
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++){
            int num = 100-progresses[i];
            int day = 0;
            if(num%speeds[i] == 0){
                dayArr[i] = (int)(num/speeds[i]);
            }else{
                dayArr[i] = ((int)(num/speeds[i]))+1;
            }
        }

        for(int i = 0; i < dayArr.length; i++){
            int index = -1;
            for(int j = i+1; j < dayArr.length; j++){
                if(dayArr[i] >= dayArr[j]){
                    index = j;
                }else{
                    break;
                }
            }

            if(index != -1){
                answer.add(index-i+1);
                System.out.println("day: "+ (index-i+1));
                i = index;
            }else{
                answer.add(1);
                System.out.println("day: 1");
            }
        }

        int[] answerArr = new int[answer.size()];
        int size=0;
        for(int temp : answer){
            answerArr[size++] = temp;
        }

       return answerArr;
    }
}
