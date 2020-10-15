class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int num = (brown - 4)/2; //3
        int width=0, height=0;

        // here
        for(int i = 1; i < num; i++){
            if((i * (num-i)) == yellow){
                if((i + 2) *(num - i + 2) == brown+yellow){
                    if(i > num-i){
                        width = i;
                        height = num-i;
                    }else{
                        width = num-i;
                        height = i;
                    }
                    answer[0] = width+2;
                    answer[1] = height+2;
                    break;
                }




            }
        }

        return answer;
    }
}
