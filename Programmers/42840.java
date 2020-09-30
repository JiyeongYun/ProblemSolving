class Solution {
    public int[] solution(int[] answers) {

        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        int[] arr1 = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,
                    1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5,2,1,2,3,
                    2,4,2,5,2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5,
                   3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5,};
        int index = 0;
        for(int i = 0; i < answers.length; i++){
            int j = i - (i/40) * 40;

            if(arr1[j] == answers[i]) cnt1++;
            if(arr2[j] == answers[i]) cnt2++;
            if(arr3[j] == answers[i]) cnt3++;
        }
        int[] answer;
        if(cnt1 > cnt2){
            if(cnt1 > cnt3){        // 1 > 2,3
                answer = new int[1];
                answer[0]=1;
            }else if(cnt1 == cnt3){ //1 == 3 > 2
                answer = new int[2];
                 answer[0]=1;
                 answer[1]=3;
            }else{
                answer = new int[1];
                 answer[0]=3;
            }
        }else if(cnt1 == cnt2){
            if(cnt1 > cnt3){        //1 == 2 > 3
                answer = new int[2];
                 answer[0]=1;
                 answer[1]=2;
            }else{                  //1==2==3
                answer = new int[3];
                 answer[0]=1;
                 answer[1]=2;
                 answer[2]=3;
            }
        }else{
            if(cnt2 > cnt3){        // 2 > 1,3
                answer = new int[1];
                 answer[0]=2;
            }else if(cnt2 == cnt3){ // 2 == 3 > 1
                answer = new int[2];
                 answer[0]=2;
                 answer[1]=3;
            }else{                  // 3 > 2 > 1
                answer = new int[1];
                 answer[0]=3;
            }
        }
        return answer;
    }
}
