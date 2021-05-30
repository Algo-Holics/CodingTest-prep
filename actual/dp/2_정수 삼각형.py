n = int(input())

result = 0
triangle = []
for _ in range(n):
    triangle.append(list(map(int, input().split())))


for i in range(1, n):
    for j in range(len(triangle[i])):

        # (가로 기준) 0번째거나 마지막인 경우
        # 0인 경우: 바로 전 0번째만 가능
        if j == 0:
            triangle[i][j] += triangle[i-1][j]

        # 마지막인 경우 바로 전의 마지막꺼만 가능
        elif j == len(triangle[i]) - 1:
            triangle[i][j] += triangle[i-1][j-1]

        else:
            triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])

print(max(triangle[n-1]))
