n = int(input())
d = [0]*(n+1)

d[1] = 1    # 가로길이 1인 거 한개
d[2] = 3    # 가로길이 2인게 3개

for i in range(3, n+1):
    d[i] = 2*d[i-2]+d[i-1] % 796796

print(d)
