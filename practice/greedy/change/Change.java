package greedy.change;

import java.util.Arrays;
import java.util.List;

class Change {

    private static final Integer FIVE_HUNDRED_COIN = 500;
    private static final Integer HUNDRED_COIN = 100;
    private static final Integer FIFTY_COIN = 50;
    private static final Integer TEN_COIN = 10;

    public static void main(String[] args){
        int numberOfCoin = 0;
        int N = 3500;

        List<Integer> coins = Arrays.asList(FIVE_HUNDRED_COIN, HUNDRED_COIN, FIFTY_COIN, TEN_COIN);

        for (Integer coin : coins) {
            numberOfCoin += (N / coin);
            N %= coin;

            if (N == 0) {
                break;
            }
        }

        System.out.println(numberOfCoin);
    }
}
