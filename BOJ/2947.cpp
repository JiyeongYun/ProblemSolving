#include <iostream>
#include <vector>
using namespace std;

int main(){
    int n, size, isSuccess = false;
    vector<int> v;

    for(int i = 0; i < 5; i++){
        scanf("%d", &n);
        v.push_back(n);
    }

    size = v.size();
    v.resize(v.size());

    while(!isSuccess){
        for(int i = 0; i < size-1; i++){
            if(v[i] > v[i+1]){
                int temp = v[i];
                v[i] = v[i+1];
                v[i+1] = temp;

                isSuccess = true;
                for(int j = 0; j < size; j++){
                    printf("%d ", v[j]);
                    if(j != size-1 && v[j] > v[j+1]) isSuccess = false;
                }
                printf("\n"); 
            } 
        }   
    }

    return 0;
}
