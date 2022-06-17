package com.anzhi.memoryreordering;

public class MemoryReorderingDemo {
    private static  int x = 0, y = 0;
    private static  int a = 0, b =0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for(;;) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(new Runnable() {
                public void run() {
                    //由于线程one先启动，下面这句话让它等一等线程two. 读着可根据自己电脑的实际性能适当调整等待时间.
                    shortWait(100000);
                    a = 1;
                    x = b;
                }
            });

            Thread other = new Thread(new Runnable() {
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            one.start();
            other.start();

            one.join();
            other.join();

            String result = "第" + i + "次 (" + x + "," + y + "）";
            if(x == 0 && y == 0) {  // 当两个线程中的 a = 1;x = b; 以及 b = 1; y = a; 指令换位置的时候, 就会出现 x=y=0的情况
                System.err.println("当两个线程中的 a = 1;x = b; 以及 b = 1; y = a; 指令换位置的时候, 就会出现 x=y=0的情况" + result);
                break;
            } else {
                //System.out.println(result);
            }
        }
    }


    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while(start + interval >= end);
    }
}