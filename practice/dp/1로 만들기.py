import time
start = time.time()
###############################
x = int(input())
d = [0] * (x+1)

for i in range(2, x+1):
    d[i] = d[i-1]+1
    if i%2 == 0:
        d[i] = min(d[i], d[i//2]+1)
    if i%3 == 0:
        d[i] = min(d[i], d[i//3]+1)
    if i%5 == 0:
        d[i] = min(d[i], d[i//5]+1)

print(d[x])
###############################
end = time.time()
print(f'time: {end - start}')

'''
2
time: 1.3468735218048096
'''
