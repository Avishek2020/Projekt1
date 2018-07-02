import java.util.concurrent.RecursiveTask;

public class FibonacciE extends RecursiveTask<Integer> {
	   final int n;
	   FibonacciE(int n) { this.n = n; }
	   protected Integer compute() {
	     if (n <= 1)
	        return n;
	     FibonacciE f1 = new FibonacciE(n - 1);
	     f1.fork();
	     FibonacciE f2 = new FibonacciE(n - 2);
	     return f2.compute() + f1.join();
	   }
	 }