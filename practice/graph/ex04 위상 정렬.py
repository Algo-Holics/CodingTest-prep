'''
위상정렬: 순서가 정해져있는 작업들을 차례대로 수행해야할때
(마치 선수과목처럼...응통을 들으려면 확통을 듣고와야지)

진입차수: 특정 vertex로 들어오는 edge의 갯수

위상정렬
1. 진입차수가 0인 노드를 큐에 넣는다
2. 큐가 빌 때까지
    - 큐에서 노드를 꺼내서 그 노드에서 출발하는 간선을 그래프에서 제거한다
    - 새롭게 진입차수가 0이 된 노드를 큐에 넣는다

입력
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
'''
from collections import deque

v, e = map(int, input().split())

# 진입차수
indegree = [0] * (v+1)

graph = [[] for i in range(v+1)]


# 간선 정보 입력받기
for i in range(e):
    a, b = map(int, input().split())

    # a에서 b로 가는 화살표
    graph[a].append(b)
    # 진입차수 증가 (b로 들어오는 거니까)
    indegree[b] += 1

# 위상 정렬
def topology_sort():
    result = []
    q = deque()

    # 처음엔 진입차수가 0인 노드를 큐에 삽입
    for i in range(1, v+1):
        if indegree[i] == 0:
            q.append(i)

    # 큐가 빌 때까지 반복
    while q:

        # 큐에서 꺼내기
        now = q.popleft()
        result.append(now)

        # 연결된 노드들의 진입차수 1씩 빼기
        for i in graph[now]:
            indegree[i] -= 1

            # 새로운 진입차수 0인 애가 큐에 들어감
            if indegree[i] == 0:
                q.append(i)

    # 위상정렬 결과 출력
    print(*result)

topology_sort()