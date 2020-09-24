#include <iostream>
using namespace std;

int main(void){
    int N, i, quot, answer = 0;
    int coins[] = {500, 100, 50, 10, 5, 1};
    cin >> N;
    N = 1000 - N;

    for(i = 0; i < 6; i++){
        quot = N / coins[i];
        answer += quot;
        N = N - (quot * coins[i]);

        if(N <= 0) break;
    }
  
    cout << answer << endl;
    return 0;
}