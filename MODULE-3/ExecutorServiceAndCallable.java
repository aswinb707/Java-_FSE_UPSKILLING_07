import java.util.*;
import java.util.concurrent.*;
public class ExecutorServiceAndCallable {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = Arrays.asList(
            () -> "Task 1 result",
            () -> "Task 2 result",
            () -> "Task 3 result"
        );
        List<Future<String>> results = executor.invokeAll(tasks);
        for (Future<String> future : results) {
            System.out.println("Result: " + future.get());
        }
        executor.shutdown();
    }
}
