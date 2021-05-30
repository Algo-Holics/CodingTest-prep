from bisect import bisect_left, bisect_right


def count_range(array, left, right):
    left_idx = bisect_left(array, left)
    right_idx = bisect_right(array, right)
    return right_idx - left_idx


n, x = map(int, input().split())
numbers = list(map(int, input().split()))

result = count_range(numbers, x, x)
if result == 0:
    print(-1)
else:
    print(result)

'''
7 2
1 1 2 2 2 2 3

7 4
1 1 2 2 2 2 3
'''