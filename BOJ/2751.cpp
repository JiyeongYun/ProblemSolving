#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n, num;
    vector<int> v;
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
        scanf("%d", &num);
        v.push_back(num);
    }

    v.resize(v.size());
    sort(v.begin(), v.end());

    for(int i = 0; i < n; i++){
        printf("%d\n",v[i]);
    }

    return 0;
}

