#include <iostream>
#include <stack>
using namespace std;

int main(){
    int size, num, answer = 0;
    vector<int> v;
    
    scanf("%d", &size);
    for(int i = 0; i < size; i++){
        scanf("%d", &num);
        if(num == 0) s.pop();
        else s.push(num);
    }

    while(!s.empty()){
        answer += s.top();
        s.pop();
    }

    printf("%d",answer);
    return 0;
}

