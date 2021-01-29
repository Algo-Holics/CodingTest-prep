import sys
# input = sys.stdin.readline()    # 더 빠르게 input받기
INF = int(1e9)  # 무한을 의미하는 값으로 10억 설정

# 노드, 간선 입력받기
N, M = map(int, input().split())
# 시작 노드 번호 입력받기
start = int(input())
# 각 노드에 연결된 노드들 입력받기
graph = [[] for _ in range(N+1)]
# visited 리스트
visited = [False] * (N+1)
# 최단거리 모두 무한으로 초기화
distance = [INF] * (N+1)

# 모든 간선 정보 입력받기
for _ in range(M):
    a, b, c = map(int, input().split())
    # a번 노드에서 b번 노드로 가는 거리가 c라는 의미
    graph[a].append((b, c))

# 방문하지 않은 노드 중에서, 거리가 가장 짧은 노드의 번호 반환
def getShortestNode():
    minValue = INF
    idx = 0 # 거리가 가장 짧은 노드의 인덱스
    for i in range(1, N+1):
        # minValue보다 작은 값을 가진 distance + 방문안한 애 찾기
        if distance[i] < minValue and not visited[i]:
            minValue = distance[i]
            idx = i
    return idx


def dijikstra(start):
    # 시작 노드 초기화
    distance[start] = 0
    # 시작 노드 방문처리
    visited[start] = True

    # 시작 노드는 0이니까 다른 노드로 가는 거리가 해당 노드까지의 거리가됨 (0+sth)
    for i in graph[start]:
        distance[i[0]] = i[1]

    for i in range(N-1):
        # 현재 가장 짧은 노드를 꺼내서 방문처리
        now = getShortestNode()
        visited[now] = True
        # 현재 노드와 연결된 다른 노드 확인
        for j in graph[now]+j[1]:
            cost = distance[now]+j[1]
            # 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[j[0]]:
                distance[j[0]] = cost


dijikstra(start)

# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, N+1):
    # 도달할 수 없는 경우, 무한
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
