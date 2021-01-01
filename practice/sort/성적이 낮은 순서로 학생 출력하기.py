'''
2
홍길동 95
이순신 77
'''
import time
start = time.time()
#################################
N = int(input())
scores = sorted([list(map(str, input().split())) for _ in range(N)], key=lambda x: x[1])

for name in scores:
    print(name[0], end=' ')

#################################
end = time.time()
print(f'time: {end-start}')

'''
이순신 홍길동 
time: 0.8561909198760986
'''