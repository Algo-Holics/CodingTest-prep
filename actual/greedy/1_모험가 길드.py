'''
전체 N명
element는 그룹 인원이 자기 이상만큼 있어야한다
ex) 2 ==> 한 그룹에 2명 이상
최대 그룹 갯수 구하기

- 그룹 정렬
- max의 길이만큼 리스트를 하나씩 채운다

'''
import time

N = int(input())
ppl = list(map(int, input().split()))

#########################################
start = time.time()
#########################################

ppl = sorted(ppl)

idx = N-1
cnt = 0

while idx > -1:
    stack = []

    for i in range(ppl[idx]):
        if len(stack) == 0:
            stack.append(ppl[idx])

        elif stack[-1] >= ppl[idx]:
            stack.append(ppl[idx])

        idx -= 1

    cnt += 1
    stack.clear()

print(cnt)

#########################################
end = time.time()
print(f'time: {end-start}')
'''
5
2 3 1 2 2
=== 2
'''