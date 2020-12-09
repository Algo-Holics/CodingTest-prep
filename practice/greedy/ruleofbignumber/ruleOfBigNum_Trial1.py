'''
- input리스트를 idx랑 같이 정렬 (max~min 순서로)
- for i: 1~M+1까지
    - if i = K의 배수: 정렬 후 2번째 더하기
    - else: 정렬후 1번째 더하기

5 8 3
2 4 5 4 6

5 7 2
3 4 3 4 3
'''
import time

# 시작시간
start = time.time()
###########################

N, M, K = map(int, input().split())
nList = list(map(int, input().split()))

# 인덱스랑 정렬하기
nList = sorted([(n, idx) for idx, n in enumerate(nList)], reverse=True)
# print(nList)

total = 0
for i in range(1, M+1):
    if i % K == 0:
        total += nList[1][0]
    else:
        total += nList[0][0]

print(total)
###########################

# 끝난 시간
end = time.time()
print(f'time: {end-start}')

'''
46
time: 1.1212525367736816
28
time: 1.4828381538391113
'''