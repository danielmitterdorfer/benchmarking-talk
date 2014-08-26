package name.mitterdorfer.benchmark.jmh;

import org.openjdk.jmh.annotations.*;

/**
 *  Benchmark to determine the performance of summing up N array elements (N in this example is 10.000).
 */
@State(Scope.Benchmark) // Share the same state instance (i.e. the field 'values') for the whole benchmark
public class SumBenchmark {
    private double[] values;

    // Methods annotated with @Setup are run outside the actual scope of the benchmark (just as expected)
    @Setup
    public void setup() {
        this.values = new double[10000];
        for (int i = 0; i < values.length; i++) {
            values[i] = (double)i;
        }
    }

    // The actual benchmark has to be annotated with @Benchmark, that's all.
    // To avoid dead code elimination always return a value.
    // If multiple return values are involved, use the Blackhole API
    @Benchmark
    public double calculateSum() {
        return sum(values);
    }

    // This is the code we want to benchmark. For simplicity it's embedded here
    private static double sum(double[] array) {
        double total = 0.0d;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total;
    }

}
