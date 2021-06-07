# 특정 원소의 부모(=속한 집합) 찾기
def find_parent(parent, x):
    # 연결노드 없을 때까지 부모 찾기
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

# 각 요소들의 부모 찾기
def union(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    # 더 작은 수가 부모가 됨
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


n, m = map(int, input().split())

# 부모 테이블 초기화
parent = [0] * (n + 1)
for i in range(1, n + 1):
    parent[i] = i

# Union 연산을 각각 수행
for i in range(n):
    data = list(map(int, input().split()))
    for j in range(n):
        if data[j] == 1: # 연결된 경우 합집합(Union) 연산 수행
            union(parent, i + 1, j + 1)

# 여행 계획
plan = list(map(int, input().split()))

result = True
# 여행 계획에 속하는 모든 노드의 루트가 동일한지 확인
for i in range(m - 1):
    if find_parent(parent, plan[i]) != find_parent(parent, plan[i + 1]):
        result = False

if result:
    print("YES")
else:
    print("NO")