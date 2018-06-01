import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Comands{
    int findMin(ArrayList<Integer> list){
        return Collections.min(list);
    }
    int findMax(ArrayList<Integer> list){
        return Collections.max(list);
    }
    private int sum(ArrayList<Integer> list){
        int sum = 0;
        for(int x: list)
            sum += x;
        return sum;
    }
    double mean(ArrayList<Integer> list){
        return (double)sum(list)/list.size();
    }
}
class TimeChecker extends Thread{
    private long timeWork = lab13.time;
    public void run(){
        long start = System.currentTimeMillis();
        while( System.currentTimeMillis() - start < timeWork){

        }
        System.out.println("Program duration: " +(System.currentTimeMillis() - start));
        System.exit(0);
    }
}
class ThirdThread extends Thread{

    public void run(){
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Comands().findMin(lab13.list));
        System.out.println("Third thread duration: " + ( System.currentTimeMillis() - start));
    }
}
class AnotherThread extends Thread{
    public void run(){
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Comands().findMax(lab13.list));
        System.out.println("Second thread duration: " + ( System.currentTimeMillis() - start));
    }
}

class lab13 extends Thread {
    static ArrayList<Integer> list = new ArrayList<>();
    static long time = 0;
    public void run() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Comands().mean(lab13.list));
        System.out.println("First thread duration: " + ( System.currentTimeMillis() - start));
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 10000; i++){
            list.add(i);
        }
        time = scanner.nextLong();
        (new TimeChecker()).start();
        (new lab13()).start();
        (new AnotherThread()).start();
        (new ThirdThread()).start();
    }
}
