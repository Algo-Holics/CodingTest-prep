
S = input()

result = 0

# 연속된 묶음들의 길이끼리 잘라서 넣을 리스트
lengths = []
# 연속문자 확인용 (시작은 첫 인덱스의 문자열부터)
series = S[0]

# 연속문자의 마지막 값이랑 다르면
# 여태까지의 연속문자의 길이를 lengths에 넣어줌
# 만약 같으면 연속문자에 계속 넣어줌
for i in range(1, len(S)):
    if S[i] != series[-1]:
        lengths.append(len(series))
        series = S[i]
    else:
        series += S[i]
lengths.append(len(series))

if len(lengths) == 1:
    result = 0
else:
    result = len(lengths) // 2

print(result)
