def solution(text):
    lengths = []

    # 최대 길이는 전체 텍스트 길이의 반만 가능
    # ex: abcdefg ==> abc, def, g 이렇게 나눠서 비교 가능 이 이상의 길이는 연속돼서 나타날 수가 없음
    max_len = len(text)//2

    # 길이가 1인 text는 비교할 수가 없음
    if max_len == 0:
        return 1

    # 가능한 패턴의 길이만큼 돌린다
    # max_length를 포함한만큼 돌려야하니 +1
    for length in range(1, max_len+1):

        cnt = 1             # 패턴이 있는 상태로 비교하니 cnt는 1부터 시작
        compressed = ""     # 압축된 결과를 담을 임시 스트링

        pattern = text[:length]     # 가능한 패턴의 길이만큼 뽑는다
        left = len(text) % length   # 패턴을 뺀 전체 text의 길이가 홀수일 수 있으니 나중에 더해줄 용도

        # pattern 바로 다음 문자부터 text의 끝까지, 패턴 길이만큼 증가시키기
        for i in range(length, len(text)+1, length):

            # 다음 패턴 미리 구해두기
            next_pattern = text[i:i+length]

            # 만약 같으면 압축 가능하니 cnt 증가
            if pattern == next_pattern:
                cnt += 1
            else:
                # cnt가 1이라면 그동안 압축된 거 없었음 = 연속된 패턴 없었음 = 압축 실패
                # 따라서 그냥 지금까지 있던 문자열들을 compressed에 추가해줌
                if cnt == 1:
                    compressed += pattern

                # cnt가 1이 아니라면 현재 pattern이 압축된 전적이 있는 것
                # compressed에 몇번 압축됐는지 포함해서 추가해줌
                # 다음 패턴을 위해 cnt는 1로 다시 바꿔줌
                else:
                    compressed += str(cnt) + pattern
                    cnt = 1

                # 다음 패턴으로 갱신해줌
                pattern = next_pattern

        # 다음 길이로 넘어가기 전에 압축된 결과의 길이를 lengths 리스트에 넣어줌
        # 혹시 length로 나눠떨어지지 않아서 남은 문자열들이 있었다면 남은 애들의 길이도 추가해줌
        lengths.append(len(compressed)+left)

    # 최솟값 리턴하기
    return min(lengths)
