class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);

    }

    public int dfs(int[] numbers, int target, int level, int sum){
        if(level == numbers.length){
            if(target == sum) return 1;
            else return 0;
        }

        return dfs(numbers, target, level+1, sum + numbers[level])+ dfs(numbers, target, level+1, sum - numbers[level]);

    }
}
