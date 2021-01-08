'''
4 6
19 15 10 17
'''
import time
start = time.time()
#########################################
N, M = map(int, input().split())
tteoks = sorted(list(map(int, input().split())))

def binarySearch(atLeast, start, end):
    while start <= end:
        mid = (start+end) // 2
        currentSum = 0
        for i in range(N):
            if tteoks[i] > mid:
                currentSum += tteoks[i]-mid
        if currentSum > atLeast:
            start += 1
        elif currentSum < atLeast:
            end -= 1
        else:
            return mid

print(binarySearch(M, tteoks[0], tteoks[N-1]))

#########################################
end = time.time()
print(f'time: {end-start}')
'''
15
time: 1.2344036102294922
'''