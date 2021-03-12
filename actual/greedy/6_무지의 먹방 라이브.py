'''
음식 하나가 0이 되는 시간 = 음식 양 * 있는 리스트 길이
- 리턴 -1이 나오는 경우 = 모든 음식 다 먹고도 시간이 남을 때
- PriorityQueue는 제일 작은 값부터 빼버린다
- enumerate를 이용하면 (음식양, 인덱스) 튜플 만들 수 있음
-
'''

from queue import PriorityQueue


def solution(food_times, k):

    # 모든 음식을 먹을 수 있는 시간보다 k가 크거나 같다면 다 먹을 수 있음
    if sum(food_times) <= k:
        return -1

    # 우선수위큐를 만들고 (음식양, 인덱스) 튜플을 넣어줌
    que = PriorityQueue()
    for idx, food in enumerate(food_times):
        que.put((food, idx+1))

    # 제일 양 적은 거 = 얘가 제일 먼저 0이 됨 = 인덱스 스킵하게 되니까 없애도 ㄱㅊ
    # que[0][0] << 이런거 안됨. 우선순위큐는 iterable 하지 않음
    # 우선순위큐는 알아서 젤 작은놈부터 정렬시킴

    min_food = que.queue[0][0]

    # 방금 전까지 먹던 음식
    # 맨 처음엔 먹은 게 없으니 0으로 둔다
    previous = 0

    # (현재 제일 적은 음식 - 방금 전까지 먹던 음식) * 큐 사이즈
    # = 제일 양 적은 음식을 다 먹을 때까지 걸리는 시간
    # k - (적은양먹는시간) 이 0보다 크다 = 아직 먹을 시간이 남아있다
    while k - ((min_food - previous) * que.qsize()) >= 0:

        # 시간이 남았으면 우선 제일 적은걸 다 먹었다 치고 그만큼 전체 시간에서 빼준다
        k -= (min_food - previous) * que.qsize()

        # 그럼 방금 다 먹었으니 previous를 갱신해주고 그거 인덱스도 우선 킵
        # print(que.get())
        previous = que.get()[0]

        # 아직 시간 남았는데 남은 음식이 없다 = 리턴 -1
        if que.empty():
            return -1

        # 방금 하나 다 먹었으니 다시 양 제일 적은거 갱신해줌
        min_food = que.queue[0][0]

    # WHAT ON EARTH DOES THIS PART FUCKING MEAN? OMG I WANNA KILL MYSELF
    que.queue = sorted(que.queue, key=lambda x:x[1])
    return que.queue[k % len(que.queue)][1]


food_list = list(map(int, input().split()))
k = int(input())
print(solution(food_list, k))
# solution(_list, K)

'''
3 1 2
5
=== 1
'''