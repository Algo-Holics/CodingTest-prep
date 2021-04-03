package algo.imple;

public class ExteriorWallInspection {
    public static void main(String[] args) {
        System.out.println(new Solution1().solution(12, new int[]{1,5,6,10}, new int[]{1,2,3,4}));
        System.out.println(new Solution1().solution(12, new int[]{1,3,4,9,10}, new int[]{3, 5, 7}));
    }
}

// 잘 모르겠어서 참조 구현. (+ 1주 후에 다시 해보겠음)
class Solution1{
    int n, r = 0;                       //n: 문제에서 주어진 외벽의 길이, r: 선택한 친구의 수
    int[] weak, dist, choice;           //choice: 가능한 dist 순열 담는 배열
    int[][] rotateWeak;                 //weak 배열이 가능한 모든 경우를 담는 배열
    boolean flag;                       //최소 친구로 가능한 것 찾은 경우 true

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = weak;
        this.dist = dist;

        //1. weak 가 가능한 모든 경우를 rotateWeak 에 담아주기
        setWeak();

        //2. 친구들 수에 맞는 순열을 구하고 그 친구들만 보내서 외벽 점검이 가능하면 반복문 종료
        for(int i = 1 ; i <= dist.length; i++){
            r = i;                          // 전체 길이중 몇개 선택?
            choice = new int[r];            // i의 크기만큼 가능한 dist 순열 결과
            boolean[] visited = new boolean[dist.length];
            permutation(0, visited);
            if(flag) break;
        }

        //3. 외벽 점검이 가능했던 경우에는 최소 친구 수인 r 을 반환하고, 아닌 경우 -1 반
        return flag ? r : -1;
    }

    private void permutation(int depth, boolean[] visited) {
        if(flag) return;
        if(depth == r){
            check();
            return;
        }

        for(int i = 0; i < dist.length; i++){
            if(!visited[i]){
                choice[depth] = dist[i];
                visited[i] = true;
                permutation(depth+1, visited);
                visited[i] = false;
            }
        }
    }

    private void check() {
        // 3.1 가능한 weak 순서를 다 체크한다.
        for(int[] weak: rotateWeak){
            int start = 0;                              //체크를 시작할 기준점
            int choiceIdx = 0;                          //순열 결과를 순회할 idx
            int len = weak.length;                      //전체 배열 길이 (반복되서 추가한 변수)
            boolean[] chechked = new boolean[len];      //친구들이 돌아다녀서 점검이 되었는지 유무를 담는 배열

            // 3.2 선택한 조합의 친구들을 모두 확인해볼때까지 반복해보기
            while(choiceIdx < r){
                int i = start;
                int value = choice[choiceIdx++];

                for(int j = start; j < len; j++){
                    //3.3 간격이 친구가 0보다 크거나 같고, 친구가 갈수있는 거리보다 작거나 같으면 갈 수 있음.
                    if(0<= weak[j] - weak[i] && weak[j]- weak[i] <= value){
                        chechked[j] = true;
                        start++;
                    }else{
                        break;
                    }
                }
            }

            if(isFinish(chechked)){
                flag = true;
                return;
            }
        }
    }

    private boolean isFinish(boolean[] chechked) {
        for(boolean c: chechked){
            if(!c) return false;
        }
        return true;
    }

    private void setWeak() {
        int len = weak.length;
        rotateWeak = new int[len][len];

        //i: weak 를 돌고자 하는 시작점
        for(int i = 0; i < len; i++){
            rotateWeak[i] = changeWeak(i);
        }
    }

    private int[] changeWeak(int idx) {
        int len = weak.length;
        int[] ret = new int[len];

        for(int i = 0; i < len; i++){
            int b = i + idx;
            if(b < len) ret[i] = weak[b];
            else ret[i] = weak[b - len] + n;
        }

        return ret;
    }
}
