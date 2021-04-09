# 90도 오른쪽으로 회전
def rotate(key, key_len):
    result = [[0] * key_len for _ in range(key_len)]
    for i in range(key_len):
        for j in range(key_len):
            result[i][j] = key[key_len-1-j][i]
    return result


# 돌기
def move(key, lock, pad_length, key_len, lock_len, row, col):

    # 자물쇠에 패딩을 만들어준다
    padded_lock = [[0] * pad_length for _ in range(pad_length)]

    # 열쇠를 꽂아본다
    for i in range(key_len):
        for j in range(key_len):
            padded_lock[row+i][col+j] += key[i][j]

    # 그 위에 자물쇠를 덮어본다
    center = key_len - 1
    # ???????????????????????????????????

    # for i in range(lock_len-1, 2*lock_len-1):
    #     for j in range(lock_len-1, 2*lock_len-1):
    for i in range(center, center+lock_len):
        for j in range(center, center+lock_len):
            # padded_lock[i][j] += lock[i-lock_len+1][j-lock_len+1]
            padded_lock[i][j] += lock[i - center][j - center]
            # 안 맞으면 바로 false
            if padded_lock[i][j] != 1:
                return False

    # 자물쇠가 다 1이면 true
    return True


def solution(key, lock):
    key_len = len(key)
    lock_len = len(lock)
    # print(*key, sep="\n")

    pad_length = lock_len + 2 * (key_len - 1)
    for _ in range(4):

        # [패딩의 길이 - 열쇠 길이(+1 해야 포함)]만큼 돌기
        for row in range(pad_length - key_len + 1):
            for col in range(pad_length - key_len + 1):
                if move(key, lock, pad_length, key_len, lock_len, row, col):
                    return True
        key = rotate(key, key_len)
    return False


print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 0], [1, 0, 1]]))