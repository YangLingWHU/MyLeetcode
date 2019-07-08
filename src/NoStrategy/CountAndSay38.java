package NoStrategy;

public class CountAndSay38 {
    public String countAndSay(int n) {
        StringBuilder rt =  new StringBuilder("1");
        StringBuilder tempStr = new StringBuilder("1");

        for (int index = 0; index < n - 1; index++) {
            int i = 0;
            int j = 0;
            rt = new StringBuilder();
            int len = tempStr.length();
            while (j < len) {
                while (j < tempStr.length() && tempStr.charAt(i) == tempStr.charAt(j)) {
                    j++;
                }
                rt.append(String.valueOf(j - i)).append(tempStr.charAt(i));
                i = j;
            }
            tempStr = rt;

        }
        return rt.toString();
    }

    public static void main(String[] args) {
        CountAndSay38 o = new CountAndSay38();
        System.out.println(o.countAndSay(4));
    }
}
