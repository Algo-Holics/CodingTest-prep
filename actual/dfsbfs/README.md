# DFS & BFS Mini's 생각 정리

### 01. 특정거리의 도시 찾기

* [문제링크](https://www.acmicpc.net/problem/18352)
* 🧐 사고의 흐름 
  1. 최단거리가 나와서 바로 다익스트라라고 생각했었다.
  2. 그런데 **가중치가 없고, 최단 경로**를 구하는 문제에서 보통 **BFS** 로 탐색한다 라는 말을 최근에 들어서 BFS로 접근했다.(queue). 시작점으로부터 가까운 정점 순으로 방문하기 때문에 문제에 적합한 알고리즘인 듯 하다.
  3. 탐색문제에서 DFS 를 사용하면 종종 시간 초과를 봤었는데, 최단거리문제에서는 DFS보다 BFS로 접근해야겠다.
  4. 참고) DFS는 가중치 관리가 용이하고 탐색에 대한 제약 조건이 있는 문제에 적합하다고 한다.

* 구현하면서 수정을 거쳤던 부분. 
  * 인접 노드들을 담는 리스트를 2차원 리스트로 선언. 
    (Java에서 선언할 때 노드의 수만큼 돌면서 new로 생성해주는걸 잊는다. )



### 02. 연구소

* [문제링크](https://www.acmicpc.net/problem/14502)

* 🧐 사고의 흐름 

  * 이전에 python으로 풀었었는데 기억이 안났다..(충격.. 그럴수 있어)
  * 그래서 전체 로직을 참조했다.

* 로직

  * DFS + BFS 모두 사용했다.
    1. 먼저 DFS 를 돌면서 벽을 3개까지 세워본다.
    2. 벽이 3개가 되었을 때, 3개의 위치가 담긴 배열을 임시 배열에 담아두고 BFS 를 돌면서 바이러스를 퍼뜨려본다.
    3. 임시 배열에 바이러스를 다 퍼뜨린 후에 남은 safe zone을 카운트 했다.

* 구현하면서 수정을 거쳤던 부분.

  * 벽을 세운 후 임시배열에 담을 때 얕은 복사로 array.clone() 메서드를 썼었는데, 그러다보니 벽을 새롭게 세운 경우를 체크하지 못했다. 그래서 2중 for문을 돌면서 깊은 복사를 했다.

  * 상수 final로 선언(blank: 0, wall: 1, virus: 2)

    

[DFS BFS 언제? 정리](https://stackoverflow.com/questions/3332947/when-is-it-practical-to-use-depth-first-search-dfs-vs-breadth-first-search-bf)

|                                            | DFS  | BFS  |
| ------------------------------------------ | ---- | ---- |
| 단순 모든 정점 방문                        | O    | O    |
| 경로의 특징을 저장 (제약조건)              | O    |      |
| 최단거리 (가중치 X)                        |      | O    |
| 그래프가 큰 경우                           | O    |      |
| 시작지점으로부터 원하는 대상이 멀지 않을때 |      | O    |



---

[아직 안 푼 문제들]

* [경쟁적 전염](https://www.acmicpc.net/problem/18405)
* [연산자 끼워 넣기](https://www.acmicpc.net/problem/14888)
* [감시피하기](https://www.acmicpc.net/problem/18428)
* [인구이동](https://www.acmicpc.net/problem/16234)
* [블록 이동하기](https://programmers.co.kr/learn/courses/30/lessons/60063)

