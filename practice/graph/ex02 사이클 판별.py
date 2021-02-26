'''
1. 각 간선을 확인하며 두 노드의 루트노드를 확인한다
    - 루트노드가 다르면 두 노드에 대해 union
    - 루트노드가 같다면 사이클이 발생한 것

입력
3 3
1 2
1 3
2 3
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

V, E = map(int, input().split())
parent = [i for i in range(V+1)]

# 사이클 발생 여부
cycle = False

for i in range(E):
    a, b = map(int, input().split())

    # 사이클이 발생하면 종료 = 부모가 같으면 사이클
    if find_parent(parent, a) == find_parent(parent, b):
        cycle = True
        break
    else:
        union(parent, a, b)

if cycle:
    print("사이클 발생")
else:
    print("노 사이클")