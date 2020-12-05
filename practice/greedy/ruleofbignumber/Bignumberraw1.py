n, m = map(int, input().split())
card = [sorted(map(int, input().split())) for i in range(n)]

ans = -1

for i in range(n):
    if ans < card[i][0]:
        ans = card[i][0]

print(ans)


'''
1. 나의 경우 각 행마다 가장 적은 값이 왼쪽에 오도록 입력받을 때 sort했다.
2. 반복문을 돌면서 행별로 큰 값을 저장해, 가장 큰 값을 찾았다.
3. 책 풀이와 비교했을 때, 반복문이 두번 들어간다는 점이 아쉬운듯!
'''