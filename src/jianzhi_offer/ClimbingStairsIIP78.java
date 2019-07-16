package jianzhi_offer;

/**
 * 跳台阶的变种
 * https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class ClimbingStairsIIP78 {
    public int JumpFloorII(int target) {
        if (target < 3) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < target + 1; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[i] += dp[j];
            }
            dp[i] += 1;
        }
        return dp[target];
    }

    public static void main(String[] args) {
        ClimbingStairsIIP78 o = new ClimbingStairsIIP78();
        System.out.println(o.JumpFloorII(3));
    }
}
