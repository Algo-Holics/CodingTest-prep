n, m, k = map(int, input().split())
arr = sorted(map(int, input().split()), reverse=True)

first = arr[0]
second = arr[1]

ans = 0

cnt = (m // (k+1)) * k + m % (k+1)

ans += cnt * first
ans += (m - cnt) * second

print(ans)