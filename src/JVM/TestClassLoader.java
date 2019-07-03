package JVM;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


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

 class Father{
    private int i = test();
    private static int j = method();

    static{
        System.out.print("(1)");
    }
    Father(){
        System.out.print("(2)");
    }
    {
        System.out.print("(3)");
    }


    public int test(){
        System.out.print("(4)");
        return 1;
    }
    public static int method(){
        System.out.print("(5)");
        return 1;
    }
}

class Son extends Father{
    private int i = test();
    private static int j = method();
    static{
        System.out.print("(6)");
    }
    Son(){
//		super();//写或不写都在，在子类构造器中一定会调用父类的构造器
        System.out.print("(7)");
    }
    {
        System.out.print("(8)");
    }
    public int test(){
        System.out.print("(9)");
        return 1;
    }
    public static int method(){
        System.out.print("(10)");
        return 1;
    }
    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println();
        Son s2 = new Son();
    }
}
