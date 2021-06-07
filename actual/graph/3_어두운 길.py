def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b



n, m = map(int, input().split())
parent = [0] * (n + 1)
for i in range(1, n + 1):
    parent[i] = i

# 간선 입력받기
edges = []
for _ in range(m):
    x, y, length = map(int, input().split())
    # 길이로 정렬해야하니 앞에 길이 넣기
    edges.append((length, x, y))

# 정렬
edges.sort()
total = 0
result = 0

for edge in edges:
    cost, x, y = edge
    total += cost

    # 사이클이 발생하지 않는 경우에만 집합에 포함
    if find_parent(parent, x) != find_parent(parent, y):
        union(parent, x, y)
        result += cost

print(total - result)