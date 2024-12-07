package base1;

public class CpuTest {


    public static void main(String[] args) {

        Thread t1 = new Thread(()-> {
            while (true) {
                System.err.println("countAAAAAAAAAA");
            }
        } , "gaoleixiancheng111");


        Thread t2 = new Thread(()-> {
            while (true) {
                System.err.println("countBBBBBBBBBB");
            }
        } , "gaoleixiancheng222");

        t1.start();
        t2.start();
    }



}
