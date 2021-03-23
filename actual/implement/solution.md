### 04. 자물쇠와 열쇠

![lockandkey1](C:\Users\leefr\Desktop\lockandkey1.jpg)

![lockandkey2](C:\Users\leefr\Desktop\lockandkey2.jpg)

### 06. 기둥과 보

![image-20210323182030207](C:\Users\leefr\AppData\Roaming\Typora\typora-user-images\image-20210323182030207.png)

* **내가 여기서 생각을 혼자 못했던 부분**
  * board의 크기를 N+1로 처음에는 두고 구현했었음 
    * => 바닥을 구하거나, 보를 확인할때 IndexOutOf range Error가 떠서 상하좌우로 크기를 늘려서 구현함. 
  * 처음엔 시뮬레이션으로 격자판 board에 일일이 표시해가며 구현했었는데, 가능한 cols과, 가능한 rows들을 저장하는게 더 관리가 편했음.
  * 조건을 한가지 빼먹었었는데 1.4) 위에 보가 있는 경우를 생각 못했었음 ㅠㅠ
  * [참조한 링크](https://leveloper.tistory.com/100)

