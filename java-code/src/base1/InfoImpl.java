package base1;

public class InfoImpl<T> implements Info<T> {

    private T var;             // 定义属性

    public InfoImpl(T var) {     // 通过构造方法设置属性内容
        this.setVar(var);
    }

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return this.var;
    }

    @Override
    public void testMethod(T t) {
//        Info.super.testMethod(t);
        System.err.println("InfoImpl == testMethod: " + t.toString());
    }
}
