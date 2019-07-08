package JVM;

import java.util.*;


public class TestClassLoader {
//    public static void main(String[] args) {
//        String[] strings = new String[2];
//        System.out.println(strings.getClass());
//        System.out.println(strings.getClass().getClassLoader());
//        System.out.println("__________");
//        TestClassLoader[] testClassLoaders = new TestClassLoader[2];
//        System.out.println(testClassLoaders.getClass());
//        System.out.println(testClassLoaders.getClass().getClassLoader());
//        System.out.println("__________");
//        int[] ints = new int[2];
//        System.out.println(ints.getClass());
//        System.out.println(ints.getClass().getClassLoader());
//    }
}


class Test {
    public static void main(String[] args) {
        String str = "hello";
        Integer num = 100;
        int[] array = {1,2,3,4};
        MyData myData = new MyData();
        change(str, num, array, myData);
        System.out.println(str);
        System.out.println(num);
        System.out.println(Arrays.toString(array));
        System.out.println(myData.a);
    }

    public static void change(String str2, Integer num2, int[] array2, MyData myData2) {
        str2 += " world";
        num2 = 200;
        array2[0] = 9;
        myData2.a = 20;
    }
}
class MyData {
    int a = 10;
}