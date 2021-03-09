import time


number = list(map(int, input()))
start = time.time()
#########################################

result = number[0]

for i in range(1, len(number)):
    multiply = result * number[i]
    add = result + number[i]

    result = max(multiply, add)

print(result)

#########################################
end = time.time()
print(f'time: {end - start}')

'''
02984
=== 576
567
=== 210
'''