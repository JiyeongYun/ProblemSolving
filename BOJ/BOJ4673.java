package boj;

public class BOJ4673 {

	public static void main(String[] args) {
		boolean[] isNotSelfNum = new boolean[10001];
		
		for(int i = 1; i < 10001; i++) {
			int num = i;
			
			while(true) {
				String s_num = String.valueOf(num);
				for(int j = 0; j < s_num.length(); j++) {
					num += Integer.parseInt(String.valueOf(s_num.charAt(j)));
				}
				
				if(10000 < num) break;				
				isNotSelfNum[num] = true;
			}
		}
		
		for(int i = 1; i < isNotSelfNum.length; i++) {
			if(!isNotSelfNum[i]) 
				System.out.println(i);
		}
	}
}
