def solution(text):
    lengths = []

    max_len = len(text)//2
    if max_len == 0:
        return 1

    for length in range(1, max_len+1):
        cnt = 1
        tmp = ""
        pattern = text[:length]
        left = len(text) % length

        for i in range(length, len(text)+1, length):

            next_pattern = text[i:i+length]
            if pattern == next_pattern:
                cnt += 1
            else:
                if cnt == 1:
                    tmp += pattern
                else:
                    tmp += str(cnt) + pattern
                    cnt = 1
                pattern = next_pattern

        lengths.append(len(tmp)+left)

    return min(lengths)


# solution("a")
# solution("ababcdcdababcdcd")
# solution("aabbaccc")
# solution("ababcdcdababcdcd")
# solution("abcabcdede")
# solution("abcabcabcabcdededededede")
# solution("xababcdcdababcdcd")
