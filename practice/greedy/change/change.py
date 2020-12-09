'''
500, 100, 10원
N원일 때 거슬러줘야하는 동전의 최소 갯수
N은 항상 10의 배수

N = 1260
'''
coins = [500,100,10]

N = 1260
cnt = 0

for coin in coins:
    cnt += N//coin
    N %= coin

print(cnt)