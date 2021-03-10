

N = int(input())
nums = list(map(int, input().split()))

# 동전들로 만들 수 있는 최대
maxi = sum(nums)

# 동전들로 만들 수 있는 값들
sums = []

# 동전들의 부분집합의 합들을 구해서 sums에 넣어줌
for i in range(1 << N):
    tmp = 0
    for j in range(N):

        if i & (1 << j):
            tmp += nums[j]
    if tmp not in sums:
        sums.append(tmp)

# 정렬 후 1 ~ maxi 까지 sums의 내용물이랑 맞춰보면서 없는 값이 있으면 걔가 답
sums = sorted(sums)
for i in range(1, maxi):
    if sums[i] != i:
        print(i)
        break


'''
5
3 2 1 1 9
=== 8
'''