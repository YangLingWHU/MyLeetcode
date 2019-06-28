package greedy;

// https://leetcode-cn.com/problems/assign-cookies/

import java.util.Arrays;

public class AssignCookies455 {
    public int findContentChildren(int[] g, int[] s) {
        // 为了不搞乱传过来的原数组
        int childs[] = g.clone();
        int cookies[] = s.clone();
        Arrays.sort(childs);
        Arrays.sort(cookies);
        int rt = 0;
        int child = 0;  // 用来遍历childs
        int cookie = 0;  // 用来遍历cookies
        int childNum = childs.length;
        int cookiesNum = cookies.length;

        // 双重循环时间复杂度太高
//        for (int child : childs) {
//            for (int i = 0; i < cookiesNum; i++) {
//                if (child <= cookies[i]) {
//                    rt++;
//                    cookies[i] = 0;  // 吃掉的饼干用0来表示
//                    break;
//                }
//            }
//        }

        // 单重循环，但是思想类似于二重循环
        // 假设A小孩在B小孩之前，由于已经排序了，所以A小孩遍历过的饼干肯定是满足不了B小孩的，所以cookie指针不需要回溯
        while (child < childNum && cookie < cookiesNum) {
            if (childs[child] <= cookies[cookie]) {
                rt++;
                child++;
            }
            cookie++;
        }
        return rt;

    }

    public static void main(String[] args) {
        int g[] = new int[10];
        new AssignCookies455().findContentChildren(g, g);
        System.out.println(g[0]);
    }
}
