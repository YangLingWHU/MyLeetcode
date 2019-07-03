package Math;

/**
 * 生成素数序列
 * 厄拉多塞筛法
 * https://leetcode-cn.com/problems/count-primes/comments/
 */
public class CountPrimes204 {
    public int countPrimes(int n) {
        int count = 0;
        boolean notPrime[] = new boolean[1 + n];
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == true) {
                continue;
            }
            count++;

            int time = 2;
            long x = (long) (i) * time;
            while (x < n) {
                notPrime[(int) x] = true;
                time++;
                x = (long) (i) * time;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes204 countPrimes204 = new CountPrimes204();
        System.out.println(countPrimes204.countPrimes(10));
    }
}
