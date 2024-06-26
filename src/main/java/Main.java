
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        int n = 10; // Вычисление факториала для числа 10
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FactorialTask factorialTask = new FactorialTask(createArray(10));
        long result = forkJoinPool.invoke(factorialTask);
        System.out.println("Факториал " + n + "! = " + result);
    }
    public static long[] createArray(int n){
       long[] ints=new long[Math.abs(n)];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i + 1;
        }
        return ints;
    }

}
