# 문자열 S를 입력받는다
S = input()
# 문자열 S를 하나씩 돌면서 문자는 string, 숫자는 num에 넣어줌
string = []
num = 0
for s in S:
    if s.isdigit():
        num += int(s)
    else:
        string.append(s)
# string 정렬해서 뒤에 num합쳐줌
string = sorted(string)
print(*string, num, sep='')

'''
K1KA5CB7
AJKDLSI412K4JSJ9D
'''