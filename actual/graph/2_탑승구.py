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

# 탑승구, 비행기 입력받기
gate = int(input())
plane = int(input())

# 부모 테이블 초기화
parent = [0] * (gate + 1)
for i in range(1, gate + 1):
    parent[i] = i

result = 0
for _ in range(plane):
    # 현재 비행기의 부모 찾기
    data = find_parent(parent, int(input()))
    # 현재 루트가 0이라면, 종료
    if data == 0:
        break
    # break에서 안걸렸다면 합치기
    union(parent, data, data - 1)
    result += 1

print(result)