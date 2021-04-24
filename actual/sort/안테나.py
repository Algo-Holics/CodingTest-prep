N = int(input())
# 그냥 중앙값을 찾아주면됨
houses = sorted(list(map(int, input().split())))
print(houses[N//2-1])
