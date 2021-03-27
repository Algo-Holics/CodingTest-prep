def turn(key):
    n = len(key)
    result = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            result[i][j] = key[n-1-j][i]
    return result


def move(key, padding):
    m = len(key)
    p = len(padding)
    flag = True
    for i in range(p-m+1):
        for j in range(p-m+1):
            if flag:
                cnt = 1
                for k in range(m):
                    tmp = True
                    if not tmp:
                        break
                    for l in range(m):
                        if key[k][l] + padding[i+k][j+l] == 1:
                            cnt += 1
                            continue
                        else:
                            flag = False
                            tmp = False
                            break
                else:
                    return True
    else:
        return False


def solution(key, lock):

    n = len(lock)
    m = len(key)
    padding = n + 2*m - 2

    # 자물쇠랑 열쇠의 길이가 1인 경우
    if n == m == 1:
        if key[0] + lock[0] == 1:
            return True
        else:
            return False

    # M - 1만큼씩 패딩 추가
    board = [[0] * padding for _ in range(padding)]

    # 패딩 가운데 자물쇠 넣어주기
    for i in range(m):
        for j in range(m):
            board[i+m-1][j+m-1] = lock[i][j]

    cnt = 0
    while True:
        if cnt == 3:
            return False
        if move(key, board):
            return True
        else:
            key = turn(key)
            cnt += 1

    # print(*board, sep='\n')


# print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 0], [1, 0, 1]]))
print(solution([0], [1]))
# print(turn([[0, 0, 0], [1, 0, 0], [0, 1, 1]]))