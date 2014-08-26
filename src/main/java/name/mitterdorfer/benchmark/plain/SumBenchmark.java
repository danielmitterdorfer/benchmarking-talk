package name.mitterdorfer.benchmark.plain;

/**
 * Benchmark to determine the performance of summing up N array elements (N in this example is 10.000).
 *
 * BEWARE: By intention this benchmark falls victim to dead code elimination.
 *
 * Run the benchmark with -XX:+PrintCompilation to see the JIT compiler at work.
 *
 * If you're brave enough you can also try it with
 * <code>-XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:PrintAssemblyOptions=intel</code> (if on x86)
 *
 * Remember that you need a HotSpot debug build or add a dynamic library (see also the <a href="https://wikis.oracle.com/display/HotSpotInternals/PrintAssembly">OpenJDK wiki</a>).
 */
public class SumBenchmark {
    // Ensure that the batch size is large enough to allow the JIT compiler to detect hot code
    // The server compiler this threshold is by default 10.000 (see -XX:CompileThreshold)
    private static final int BATCH_SIZE = 15000;

    // This is the code we want to benchmark
    public static double sum(double[] array) {
        double total = 0.0d;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total;
    }

    public static void main(String[] args) {
        double[] array = new double[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (double)i;
        }

        // run the actual benchmark multiple times to see run to run variance
        for (int iteration = 0; iteration < 10; iteration++) {
            benchmarkSum(array);
        }
    }

    // This is the actual benchmark code - nothing fancy here
    private static void benchmarkSum(double[] array) {
        long start = System.nanoTime();
        // Single calls to #sum() may be too fast for the resolution of System#nanoTime().
        // Let's better batch some calls to increase accuracy.
        for (int j = 0; j < BATCH_SIZE; j++) {
            // This is dead code and will be eliminated by the JIT compiler after warmup.
            sum(array);
        }
        long stop = System.nanoTime();
        System.out.printf("Computation finished in %d ns.%n", ((stop - start) / BATCH_SIZE));
    }
}