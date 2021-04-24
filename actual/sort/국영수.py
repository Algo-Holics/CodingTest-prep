N = int(input())
scores = [list(map(str, input().split())) for _ in range(N)]

# lambda를 쓰면 각 조건에 대해 정렬을 할 수 있음
# 현재 모든 input을 str으로 받았기 때문에 각 점수를 int()로 변환시켜주는 것 필요
# 거꾸로 정렬은 -를 붙이면 됨
names = sorted(scores, key = lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0]))

for i in range(N):
    print(names[i][0])

# pypy에서만 성공하는 코드..!