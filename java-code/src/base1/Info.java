package base1;

public interface Info<T> {

    default void testMethod(T t) {
        System.err.println("this is testMethod:{} " + t.toString());
    }

    public T getVar() ; // 定义抽象方法，抽象方法的返回值就是泛型类型

}
