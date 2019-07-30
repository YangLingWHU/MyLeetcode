package jianzhi_offer;

/**
 * https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2
 */
public class StringNumeric20 {
    // 判断字符串能不能代表一个数字

    /**
     * []  ： 字符集合
     * ()  ： 分组
     * ?   ： 重复 0 ~ 1 次
     * +   ： 重复 1 ~ n 次
     * *   ： 重复 0 ~ n 次
     * .   ： 任意字符
     * \\. ： 转义后的 .
     * \\d ： 数字
     */
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        String regex = " [+-]?\\d*[\\.]?\\d+([eE][+-]?\\d+)? ";
        return string.matches(regex);
    }
}
