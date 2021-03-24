### 04. 자물쇠와 열쇠

![lockandkey1](https://github.com/Algo-Holics/CodingTest-prep/blob/minhee/actual/implement/img/sol4.png)

- **어려웠던 부분**
  - key가 움직여아하는 거리, padding거리까지는 구했는데
  - key를 어떻게 움직여야하는지 구현을 못했음. (4중 반복을 쓰면 안될거 같아서..) 그런데 문제에서 크기가 작게 주어져서 혹시 하고 한게 풀림.

* 문제링크 | 내가 푼 코드

### 05. 뱀







### 06. 기둥과 보

![image-20210323182030207](https://github.com/Algo-Holics/CodingTest-prep/blob/minhee/actual/implement/img/sol6.png)
* **어려웠던 부분**
  * board의 크기를 N+1로 처음에는 두고 구현했었음 
    * => 바닥을 구하거나, 보를 확인할때 IndexOutOf range Error가 떠서 상하좌우로 크기를 늘려서 구현함. 
  * 처음엔 시뮬레이션으로 격자판 board에 일일이 표시해가며 구현했었는데, 가능한 cols과, 가능한 rows들을 저장하는게 더 관리가 편했음. 또한 별도로 관리해서 col과 row가 동시에 놓인 것 까지 찾을 수 있었음!!
  * 조건을 한가지 빼먹었었는데 1.4) 위에 보가 있는 경우를 생각 못했었음 ㅠㅠ
  * [참조한 링크](https://leveloper.tistory.com/100)

* 문제링크 | 내가 푼 코드