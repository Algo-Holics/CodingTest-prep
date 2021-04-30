def binary_search(array, start, end):
    if start > end:
        return -1

    mid = (start + end) // 2
    if array[mid] == mid:
        return mid
    elif array[mid] > mid:
        return binary_search(array, start, mid-1)
    else:
        return binary_search(array, mid+1, end)


N = int(input())
numbers = list(map(int, input().split()))
fixed = binary_search(numbers, 0, N-1)
print(fixed)

'''
5
-15 -6 1 3 7

7
-15 -4 2 8 9 13 15

7 
-15 -4 3 8 9 13 15 
'''