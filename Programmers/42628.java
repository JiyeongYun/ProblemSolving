import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        ArrayList<Integer> opQueue = new ArrayList<>();

        for(int i = 0; i < operations.length; i++){
            String[] op = operations[i].split(" ");

            if(op[0].trim().equals("I")){              // input the number
                opQueue.add(Integer.parseInt(op[1]));
            } else { // only D
                if(opQueue.size() == 0) continue;

                if(op[1].trim().equals("1")){          // output the max
                    opQueue.remove(opQueue.size()-1);
                } else if(op[1].trim().equals("-1")){  // output the min
                    opQueue.remove(0);
                }
            }
            if(opQueue.size() != 0) Collections.sort(opQueue);
        }

        if(opQueue.size() == 0){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = opQueue.get(opQueue.size()-1);
            answer[1] = opQueue.get(0);
        }



        return answer;
    }
}
