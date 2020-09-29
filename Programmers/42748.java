import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        int index = 0;
        for(int i = 0; i < commands.length; i++){
            int[] temp = commands[i];
            int[] split = Arrays.copyOfRange(temp, temp[0]-1, temp[1]);

            Arrays.sort(split);
            answer[index] = temp[temp[2]-1];
            index++;
        }

        return answer;
    }
}
