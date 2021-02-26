'''
신장트리 = 사이클이 존재하지 않는 부분 그래프

크루스칼 = 가장 적은 비용으로 모든 노드 연결
- 모든 간선을 정렬 후 가장 짧은 간선부터 집합에 포함시킨다
- 사이클이 발생시킬 수 있는 간선은 포함시키지 않는다
'''

def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

v, e = map(int, input().split())
parent = [i for i in range(v+1)]

# 모든 간선을 담을 리스트 & 최종 비용
edges = []
total = 0

for i in range(e):
    a, b, cost = map(int, input().split())

    # cost를 기준으로 정렬하기 위해 튜플에 넣어서 edges에 넣어줌
    edges.append((cost, a, b))

edges.sort()

for edge in edges:
    cost, a, b = edge

    if find_parent(parent, a) != find_parent(parent, b):
        union(parent, a, b)
        total += cost

print(total)
