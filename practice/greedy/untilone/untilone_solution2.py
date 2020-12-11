'''
25 5
25 3
'''
import time

start = time.time()
###############################
N, K = map(int, input().split())
cnt = 0

while True:
    # 가장 큰 K의 배수 만들어보기
    target = (N//K)*K
    # N에서 target이 되려면 1씩 몇뻔 빼야하는지 알 수 있다
    cnt += (N-target)
    N = target
    if N < K:
        break
    cnt += 1
    N //= K
cnt += (N-1)
print(cnt)

###############################
end = time.time()
print(f'time: {end-start}')

'''
2
time: 1.190406322479248
6
time: 1.003234624862671
'''