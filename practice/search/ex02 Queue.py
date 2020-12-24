from collections import deque

q = deque()

q.append(5)
q.append(2)
q.append(3)
q.append(7)
q.popleft()
q.append(1)
q.append(4)
q.popleft()

print(q)
q.reverse()
print(q)

'''
deque([3, 7, 1, 4])
deque([4, 1, 7, 3])
'''


