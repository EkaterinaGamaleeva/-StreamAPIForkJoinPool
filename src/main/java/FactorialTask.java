import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {
    private long[] ints;


    public FactorialTask(long[] a) {
this.ints=a;
    }

    @Override
    protected Long compute() {
        if (ints.length == 2) {
            return ints[0] * ints[ints.length - 1];
        }
        if (ints.length == 1) {
            return ints[0];
        }
            FactorialTask task1 = new FactorialTask(Arrays.copyOfRange(ints, 0, ints.length / 2));
            FactorialTask task2 = new FactorialTask(Arrays.copyOfRange(ints, ints.length / 2, ints.length));
            task1.fork();
            task2.fork();
            return task1.join() * task2.join();
        }
    }
