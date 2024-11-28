package base1;

import java.util.*;

public class App {

    private static <T extends Number> double add(T a, T b) {
        System.out.println(a + "+" + b + "=" + (a.doubleValue() + b.doubleValue()));
        return a.doubleValue() + b.doubleValue();
    }


    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");

        System.out.println(cache); // {1=a, 2=b, 3=c}

        // 访问元素
        cache.get(1);
//        cache.get(3);
        cache.put(4, "d"); // 此操作会因为缓存限制移除最少访问的元素: 2=b

        System.out.println(cache); // {3=c, 1=a, 4=d}
    }


    public static void main4(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
//        list.ensureCapacity(20);
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }


        List<Integer> integers = Collections.synchronizedList(list);

        Thread t1 = new Thread(()-> {
            for (Integer next : integers) {
                if (next < 9999) {
                    integers.set(next, next + 1);
                }
            }
        });

        Thread t2 = new Thread(()-> {
            integers.remove(2);
        });

        t1.start();
        t2.start();
    }

    public static void main3(String arsg[]){
        Info<String> i = null;        // 声明接口对象
        i = new InfoImpl<String>("汤姆") ;  // 通过子类实例化对象
        System.out.println("内容：" + i.getVar()) ;
        i.testMethod("hahaha");
//        i.testMethod(new Person("222" , 33));

    }


    public static void main2(String[] args) {
        Notepad<String, Integer> t = null;        // 定义两个泛型类型的对象
        t = new Notepad<String, Integer>();       // 里面的key为String，value为Integer
        t.setKey("汤姆");        // 设置第一个内容
        t.setValue(20);            // 设置第二个内容
        System.out.print("姓名；" + t.getKey());      // 取得信息
        System.out.print("，年龄；" + t.getValue());       // 取得信息

    }


    public static void main1(String[] args) {
        Point<String> p = new Point<String>();     // 里面的var类型为String类型
        p.setVar("it");                            // 设置字符串
        System.out.println(p.getVar().length());   // 取得字符串的长度

        Point<Person> p1 = new Point<>();
        p1.setVar(new Person("gaolei", 22));
        System.err.println(p1);
    }

}
