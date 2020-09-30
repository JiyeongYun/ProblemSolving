class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int min = length -1;

        for(int i = 0; i < length; i++){
            if(name.charAt(i)<='M') {
				answer += name.charAt(i) - 'A';
			} else {
				answer +='Z' - name.charAt(i) + 1;
			}

            int next = i+1;
			while(next<length && name.charAt(next)=='A') {
				next++;
			}
			min = Math.min(min,i+length-next+Math.min(i,length-next));

        }

        answer += min;
        return answer;
    }
}
