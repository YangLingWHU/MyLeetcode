package greedy;

public class IsSubsequence392 {

    // 尝试用Java的 indexOf方法
    // s是子串 t是长串
    public boolean isSubsequence(String s, String t) {
        int indexS = 0;
        int indexT = 0;
        int lenS = s.length();
        int lenT = t.length();
        while (indexS < lenS && indexT < lenT) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
                indexT++;
                continue;
            }
            indexT++;
        }
        if (indexS == lenS) {
            return true;
        } else {
            return false;
        }
    }
}
