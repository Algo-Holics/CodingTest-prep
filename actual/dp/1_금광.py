t = int(input())

for tc in range(t):

    n, m = map(int, input().split())
    gold = [[0] * m for _ in range(n)]

    tmp = list(map(int, input().split()))
    mine = []
    for i in range(0, len(tmp), m):
        mine.append(tmp[i:i+m])

    top, middle, bottom = 0, 0, 0
    for x in range(1, m):    # 가로 고정
        for y in range(n):   # 세로 이동
            
            # 현재 세로칸이 0번째라면 왼쪽위가 존재하지 않으니 0
            if y == 0:
                top = 0
            else:
                top = mine[y-1][x-1]

            # 현재 세로칸이 마지막번째라면 왼쪽아래가 존재하지 않으니 0
            if y == n-1:
                bottom = 0
            else:
                bottom = mine[y+1][x-1]
            
            # 중간은 언제나 존재
            middle = mine[y][x-1]

            # 왼쪽위, 왼쪽아래, 중간 중 가장 큰 값을 찾아서 현재 위치에 더해줌
            mine[y][x] = mine[y][x] + max(top, bottom, middle)
    
    # 결과는 마지막 세로줄의 값들 중 최대값
    result = max([mine[i][m-1] for i in range(n)])
    
    print(result)





'''
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4 
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
'''