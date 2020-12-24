import time

start = time.time()
#########################################
def factorial_iterative(n):
    result = 1
    for i in range(1, n+1):
        result *=i
    return result

factorial_iterative(500)
#########################################
end = time.time()
print(f'factorial_iterative: {end-start}')

start = time.time()
#########################################
def factorial_recursive(n):
    if n<=1:
        return 1
    return n * factorial_recursive(n-1)

factorial_recursive(500)
#########################################
end = time.time()
print(f'factorial_iterative: {end-start}')


'''
factorial_iterative: 0.0010004043579101562
factorial_iterative: 0.0
'''