import time
start = time.time()
###############################
moves = [(1, 2), (-1, 2), (1,-2), (-1, -2), (2, 1), (2, -1),  (-2, 1), (-2, -1)]

location = input()
col = int(ord(location[0])-96)
row = int(location[1])

cnt = 0
for move in moves:
    if 0 < row+move[0] <= 8 and 0 < col+move[1] <= 8:
        cnt += 1
    else:
        continue

print(cnt)
###############################
end = time.time()
print(f'time: {end-start}')

'''
2
time: 1.3468735218048096
'''