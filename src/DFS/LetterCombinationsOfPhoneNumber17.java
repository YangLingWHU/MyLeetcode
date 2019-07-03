package DFS;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfPhoneNumber17 {

    // 非dfs算法
    public List<String> letterCombinations(String digits) {
        List<String> rt = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return rt;
        }
        rt.add("");
        //                0  1    2      3      4       5      6      7      8       9
        String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // digits转换为int类型的数组
        int[] num = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            num[i] = Integer.parseInt(digits.charAt(i) + "");
        }

        for (int i = 0; i < num.length; i++) {
            if (num[i] < 2) {
                continue;
            }
            List<String> temp = new ArrayList<>();
            String s1 = KEYS[num[i]];
            for (String strInRt : rt) {
                for (char c : s1.toCharArray()) {
                    temp.add(strInRt + c);
                }
            }
            rt = temp;
        }
        return rt;
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber17 o = new LetterCombinationsOfPhoneNumber17();
        System.out.println(o.letterCombinations("23"));
    }


    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {  //已将全部数选出，满足条件加入结果集，结束递归
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {  // 已经选过的数不再选
                    continue;
                }
                tempList.add(nums[i]);  //选择当前节点
                backtracking(list, tempList, nums);  //递归
                tempList.remove(tempList.size() - 1); //回溯到上一步，去掉当前节点
            }
        }
    }

}
