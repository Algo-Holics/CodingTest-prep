'''
서로소 집합 (Disjoint Sets)
- union : 합집합
- find : 특정 원소가 있는 집합이 어떤 집합이지 알려줌
- union-find : look for common elements

union-find
1. union을 통해 연결된 노드 확인
2. 모든 union을 처리할 때까지 반복

입력:
6 4
1 4
2 3
2 4
5 6
'''

# 특정 원소의 부모(=속한 집합) 찾기
def find_parent(parent, element):
    # 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀호출
    # -> parent[element] = element인 경우는 스스로 초기화된 후 연결 노드 없는 경우
    # -> 연결노드가 없을 때까지 부모를 찾는다
    if parent[element] != element:
        return find_parent(parent, parent[element])
    return parent[element]
    # return element


# UNION
def union(parent, a, b):
    # 각 요소들의 parent를 찾는다
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    
    # 더 작은 수가 부모가 됨
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


# vertex, edge 받기
V, E = map(int, input().split())

# 부모(집합) 테이블 초기화
parent = [_ for _ in range(V+1)]

# union 수행
for i in range(E):
    a, b = map(int, input().split())
    union(parent, a, b)


# 각 원소들의 집합 출력
for i in range(1, V+1):
    print(i)
    print(find_parent(parent, i), end=' ')