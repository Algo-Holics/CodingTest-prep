'''
5
8 3 7 9 2
3
5 7 9
'''
import time
start = time.time()
#########################################
N = int(input())
parts = list(map(int, input().split()))
M = int(input())
orders = list(map(int, input().split()))

def binarySearch(target, start, end):
    while start <= end:
        mid = (start+end) // 2
        if parts[mid] > target:
            end = mid - 1
        elif parts[mid] < target:
            start = mid + 1
        else:
            return "yes"
    return "no"

for check in orders:
    result = binarySearch(check, 0, N-1)
    print(result, end=" ")

#########################################
end = time.time()
print(f'time: {end-start}')
'''
time: 1.4426090717315674
'''