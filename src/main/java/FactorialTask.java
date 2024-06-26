import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {
    private long[] ints;


    public FactorialTask(long[] a) {
this.ints=a;
    }

    @Override
    protected Long compute() {
        if(ints.length <= 2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Arrays.stream(ints).reduce((a, e) -> a * e).getAsLong();
        }
        FactorialTask task1 = new FactorialTask(Arrays.copyOfRange(ints, 0, ints.length/2));
        FactorialTask task2 = new FactorialTask(Arrays.copyOfRange(ints, ints.length/2, ints.length));
        task1.fork();
        task2.fork();
        return task1.join() * task2.join();
    }

    }
