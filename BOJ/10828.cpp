#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main(){
    int size, num;
    string str;
    stack<int> s;
    
    scanf("%d", &size);
    for(int i = 0; i < size; i++){
        cin >> str;
        
        if(str.compare("push") == 0){
            cin >> num;
            s.push(num);
        } else if(str.compare("pop") == 0){
            if(s.empty()) printf("-1\n");
            else{
                printf("%d\n", s.top()); 
                s.pop();
            }
        } else if(str.compare("size") == 0){
            printf("%lu\n", s.size()); 
        } else if(str.compare("empty") == 0){
            if(s.empty()) printf("1\n"); 
            else printf("0\n"); 
        } else if(str.compare("top") == 0){
            if(s.empty()) printf("-1\n"); 
            else printf("%d\n", s.top()); 
        }
    }

    return 0;
}

