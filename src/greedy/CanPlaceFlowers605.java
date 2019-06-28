package greedy;

/**
 * https://leetcode-cn.com/problems/can-place-flowers/
 */
public class CanPlaceFlowers605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int index = 0; index < flowerbed.length; index++) {
            if (flowerbed[index] == 1) {
                index += 1;
                continue;
            }
            if (flowerbed[index] == 0) {
                if (index + 1 < flowerbed.length) {
                    if (flowerbed[index + 1] == 0) {
                        n--;
                        flowerbed[index] = 1;
                        index++;
                        continue;
                    } else {
                        index += 2;
                    }
                } else if (index == flowerbed.length - 1) {
                    n--;
                }
            }

        }
        if (n > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int flow[] = new int[]{1, 0, 0, 0, 1, 0, 0};
        boolean rt = new CanPlaceFlowers605().canPlaceFlowers(flow, 2);
        System.out.println(rt);
    }
}
