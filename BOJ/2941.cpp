#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main(){
    int answer = 0, count = 0;
    string input, key;
    vector<string> v;
    v.push_back("c="); v.push_back("c-"); v.push_back("dz="); v.push_back("d-"); v.push_back("lj"); v.push_back("nj"); v.push_back("s="); v.push_back("z=");
    v.resize(v.size());

    cin >> input;
    for(int i = 0; i < v.size(); i++){
        while(input.find(v[i]) != string::npos) input.replace(input.find(v[i]), v[i].size(), "*");
    }
     
    printf("%d", input.size()); 
    return 0;
}