#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool comp(int a, int b) {
    return a < b;
}

int solution(vector<int> people, int limit) {
    int left, right, answer = 0;

    reverse(people.begin(), people.end());
    sort(people.rbegin(), people.rend());	
    sort(people.begin(), people.end(), comp);
    
    left = 0;
    right = people.size()-1;
    
    while(left <= right){
        if(left == right ){
            answer++;
            break;
        }
        if(people[left] + people[right] > limit){
            right--; 
            answer++;
        } else {
            answer++;
            left++;
            right--;
        }  
    }
    
    return answer;
}