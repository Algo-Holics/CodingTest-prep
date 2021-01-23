'''
4
1 3 1 5
'''
n = int(input())
food = list(map(int, input().split()))

d = [0]*(n+1)
d[1] = max(food[0], food[1])    # 어짜피 최댓값 찾는거니까 둘 중 큰걸로

for i in range(2, n):
    # i번째를 못먹는 경우와 먹는 경우 중 더 큰 값을 keep
    d[i] = max(d[i-1], d[i-2]+food[i])

print(d[n-1])
