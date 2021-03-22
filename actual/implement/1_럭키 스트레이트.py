# N을 입력받을 때 다 쪼개서 리스트로 받음
N = list(map(int, input()))
# LEN = N의 길이
LEN = len(N)
# N의 자릿수의 반을 구함
middle = LEN // 2
# middle을 기준으로 왼쪽, 오른쪽으로 리스트를 쪼갠다
left = N[:middle]
right = N[middle:]
# 합이 같으면 럭키/다르면 레디
if sum(left) == sum(right):
    print("LUCKY")
else:
    print("READY")
