import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {
    private int n;
    private long[] ints;



    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        ints=new long[Math.abs(n)];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i + 1;
        }
        long sum = Arrays.stream(ints).parallel().reduce((a, e) -> a * e).getAsLong();
        return sum;

    }
}