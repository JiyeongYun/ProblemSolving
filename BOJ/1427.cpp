#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n;
    vector<int> v;
    
    scanf("%d", &n);
    while(1){
        if(n < 10){
            v.push_back(n);
            break;
        }
        v.push_back(n%10);
        n = n/10;
    }
    
    sort(v.begin(), v.end(), greater<int>());
    for(int i = 0; i < v.size(); i++){
        printf("%d",v[i]);
    }

    return 0;
}

