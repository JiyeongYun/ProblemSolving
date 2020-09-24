#include <iostream>
#include <string>
using namespace std;

int main(void){

    int N, K, i, j, order;
    cin >> N >> K;                              //input 값 받기

    int passPortWindow[100] = {0, };            // 창구 배열 선언 및 모두 0으로 초기화(아무도 없는 상태)

    for(i = 0; i < N; i++){
        cin >> order;                           // 입국장을 빠져나가는 순서 받기

        bool isPossible = false;        
        for(j = 0; j < K; j++){
            if( order > passPortWindow[j] ){    // 나보다 작은 애가 
                passPortWindow[j] = order;      // 창구에 줄을 섰다! 
                isPossible = true;
                break;
            }
        }

        if(!isPossible){
            cout << "NO" << endl;
            return 0;
        }
    }
    cout << "YES" << endl;
    return 0;
}
