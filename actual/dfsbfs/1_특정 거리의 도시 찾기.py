from collections import deque

# v=노드 / e=엣지 / k=거리 / start=시작점
v, e, k, start = map(int, input().split())

# 1부터 시작하니 v+1만큼 [] 생성하기
graph = [[] for _ in range(v+1)]

# 단방향이기 때문에 인접 리스트 형태로 연결 상태 입력 
for _ in range(e):
    a, b = map(int, input().split())
    graph[a].append(b)

visited = [0] * (v+1)
result = []


def bfs(graph, start, visited):
    # q에 (점, 거리)를 넣어줌으로써 다른 점으로 넘어갔을 때의 거리를 계산할 예정
    # 시작할 땐 0으로!
    q = deque()
    q.append((start, 0))
    visited[start] = 1

    while q:
        now, cnt = q.popleft()
        for i in graph[now]:
            if not visited[i]:
                
                newCnt = cnt + 1    # 기존의 거리 + 1을 구해둔다

                if newCnt == k:     # 만약 새로운 거리가 k와 같으면 결과 리스트에 넣어준다
                    result.append(i)
                
                q.append((i, newCnt))
                visited[i] = 1


bfs(graph, start, visited)

if result:
    result = sorted(result)     # 오름차순으로 정렬 후 프린트 해달라고 했다
    print(*result, sep="\n")
else:
    print(-1)