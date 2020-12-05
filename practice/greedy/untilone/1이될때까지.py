n, k = map(int, input().split())
cnt = 0

while True:
    if n == 1:
        break

    if n % k == 0:
        n //= k
        cnt +=1
        continue
    
    n -= 1
    cnt += 1

print(cnt)


'''
1. 나는 나눠떨어지는 경우를 먼저 고려했다. 
2. 나눠떨어질 경우 먼저 나누는 것이 가지치기를 덜 할것이라고 생각을 함.
3. (아무래도 빼는 것보다 나누는게 n이 대폭 줄기때문에...?)
'''